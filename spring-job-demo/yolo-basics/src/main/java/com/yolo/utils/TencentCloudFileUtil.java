package com.yolo.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/11/30
 * Time: 15:58
 */


public class TencentCloudFileUtil {

    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    //@Value("${tencent-cloud-bucket-name}")
    private String bucketName = "<bucketName>";
    //@Value("${tencent-cloud-bucket-url}")
    private String url = "<tencent-cloud-bucket-url>";

    //@Value("${tencent-cloud-bucket-access-key}")
    private String asscessKey = "<asscessKey>";

    //@Value("${tencent-cloud-bucket-secret-key}")
    private String secretKey = "<secretKey>";
    private static volatile TencentCloudFileUtil tencentCloudFileUtil = null;

    private TencentCloudFileUtil() {
    }

    public static TencentCloudFileUtil instance() {

        if (null == tencentCloudFileUtil) {
            synchronized (TencentCloudFileUtil.class) {
                if (null == tencentCloudFileUtil) {
                    tencentCloudFileUtil = new TencentCloudFileUtil();
                }
            }
        }

        return tencentCloudFileUtil;
    }

    private COSClient selfAuth() {
        // 1 初始化用户身份信息(secretId, secretKey)
        BasicCOSCredentials credentials = new BasicCOSCredentials(asscessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
        // 3 生成cos客户端
        return new COSClient(credentials, clientConfig);
    }

    private void showTransferProgress(Transfer transfer) {
        System.out.println(transfer.getDescription());

        do {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException var8) {
                return;
            }

            TransferProgress progress = transfer.getProgress();
            long so_far = progress.getBytesTransferred();
            long total = progress.getTotalBytesToTransfer();
            double pct = progress.getPercentTransferred();
            System.out.printf("[%d / %d]\n", so_far, total);
        } while (!transfer.isDone());

        System.out.println(transfer.getState());
    }

    public String uploadSmallFile(File localFile) {
        COSClient cosClient = selfAuth();
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg,
        // 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = System.currentTimeMillis() + "-" + localFile.getName();

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        return doUploadFile(cosClient, key, putObjectRequest);
    }

    public String uploadSmallFile(InputStream inputStream, String fileName) throws Exception {
        COSClient cosClient = selfAuth();
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg,
        // 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = System.currentTimeMillis() + "_" + fileName;

        //方法2 从输入流上传(需提前告知输入流的长度, 否则可能导致 oom)
        // 方法3 提供更多细粒度的控制, 常用的设置如下
        // 1 storage-class 存储类型, 用于设置标准(默认)、低频、近线
        // 2 content-type, 对于本地文件上传, 默认根据本地文件的后缀进行映射, 如 jpg 文件映射 为image/jpeg
        //   对于流式上传 默认是 application/octet-stream
        // 3 上传的同时制定权限(也可通过调用 API set object acl 来设置)
        // 4 若要全局关闭上传MD5校验, 则设置系统环境变量, 此设置会对所有的会影响所有的上传校验。 默认是进行校验的。
        // 关闭校验  System.setProperty(SkipMd5CheckStrategy.DISABLE_PUT_OBJECT_MD5_VALIDATION_PROPERTY, "true");
        // 再次打开校验  System.setProperty(SkipMd5CheckStrategy.DISABLE_PUT_OBJECT_MD5_VALIDATION_PROPERTY, null);
        ObjectMetadata metadata = new ObjectMetadata();
        // 设置输入流长度为inputStream.available()
        System.out.println("文件大小：" + inputStream.available());

        metadata.setContentLength(inputStream.available());
        // 设置 Content type, 默认是 application/octet-stream
        metadata.setContentType("application/octet-stream");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, metadata);
        // 设置存储类型为低频
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        return doUploadFile(cosClient, key, putObjectRequest);
    }

    public String uploadLargeFile(File localFile) {
        COSClient cosClient = selfAuth();
        String key = System.currentTimeMillis() + "-" + localFile.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        TransferManager transferManager = new TransferManager(cosClient, threadPool);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(500);
        metadata.setContentType("application/octet-stream");
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        return doUploadLarge(cosClient, key, putObjectRequest, transferManager);
    }

    public String uploadLargeFile(InputStream inputStream, String fileName) throws IOException {
        COSClient cosClient = selfAuth();
        String key = System.currentTimeMillis() + "_" + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        // 设置输入流长度为inputStream.available()
        System.out.println("文件大小：" + inputStream.available());
        metadata.setContentLength(inputStream.available());
        // 设置 Content type, 默认是 application/octet-stream
        metadata.setContentType("application/octet-stream");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, metadata);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        TransferManager transferManager = new TransferManager(cosClient, threadPool);
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        return doUploadLarge(cosClient, key, putObjectRequest, transferManager);
    }

    private String doUploadFile(COSClient cosClient, String key, PutObjectRequest putObjectRequest) {
        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String eTag = putObjectResult.getETag();
            System.out.println(eTag);
            return url + key;
        } catch (Exception e) {
            LogUtil.error("上传失败");
            e.printStackTrace();
            return null;
        } finally {
            // 关闭客户端(关闭后台线程)
            cosClient.shutdown();
        }
    }

    private String doUploadLarge(COSClient cosClient, String key, PutObjectRequest putObjectRequest, TransferManager transferManager) {
        try {
            // 本地文件上传
            Upload upload = transferManager.upload(putObjectRequest);
            Thread.sleep(10000L);
            PersistableUpload persistableUpload = upload.pause();
            upload = transferManager.resumeUpload(persistableUpload);
            showTransferProgress(upload);
            // 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
            UploadResult uploadResult = upload.waitForUploadResult();
            LogUtil.info(uploadResult.getETag());
            return url + key;
        } catch (Exception e) {
            LogUtil.error("上传失败");
            return null;
        } finally {
            // 关闭客户端(关闭后台线程)
            cosClient.shutdown();
        }
    }

    public boolean delFile(String key) {
        COSClient cosClient = selfAuth();
        try {
            cosClient.deleteObject(bucketName, key);
            LogUtil.info("删除成功");
            return true;
        } catch (Exception e) {
            LogUtil.error("删除失败");
            e.printStackTrace();
            return false;
        } finally {
            // 关闭客户端(关闭后台线程)
            cosClient.shutdown();
        }
    }

    public boolean download() {

        // todo downloadFile
        return false;
    }

    public static void main(String[] args) {
        TencentCloudFileUtil.instance().delFile("1545722142510docx");
    }
}
