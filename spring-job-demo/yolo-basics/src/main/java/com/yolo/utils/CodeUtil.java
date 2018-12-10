package com.yolo.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


public class CodeUtil {
    public CodeUtil() {
    }

    public static void generateCode(String projectRootPath, String product, String module, String table_name) throws Exception {
        Map root = new HashMap();
        root.put("product", product.replaceAll("/", "."));
        root.put("module", module);
        root.put("table_name", table_name);
        //String path = projectRootPath + "/" + product + "_facade/src/main/java/" + product + "/facade/service/" + module.replaceAll("\\.", "/") + "/";
        String path = projectRootPath +"/yolo-inface/src/main/java/" + product + "/service/" + module.replaceAll("\\.", "/") + "/";
        File file = new File(path);
        file.mkdirs();
        file = new File(file, table_name + "Service.java");
        FileOutputStream output = new FileOutputStream(file);
        output.write(FtlUtil.getFtl("templates/code_service.ftl", root).getBytes());
        output.flush();
        output.close();
        path = projectRootPath + "/yolo-service/src/main/java/" + product + "/service/bizs/" + module.replaceAll("\\.", "/") + "/";
        file = new File(path);
        file.mkdirs();
        file = new File(file, table_name + "Biz.java");
        output = new FileOutputStream(file);
        output.write(FtlUtil.getFtl("templates/code_biz.ftl", root).getBytes());
        output.flush();
        output.close();
        path = projectRootPath + "/yolo-service/src/main/java/" + product + "/service/impls/" + module.replaceAll("\\.", "/") + "/";
        file = new File(path);
        file.mkdirs();
        file = new File(file, table_name + "ServiceImpl.java");
        output = new FileOutputStream(file);
        output.write(FtlUtil.getFtl("templates/code_service_impl.ftl", root).getBytes());
        output.flush();
        output.close();
        path = projectRootPath + "/yolo-control/src/main/java/" + product + "/controller/" + module.replaceAll("\\.", "/") + "/";
        file = new File(path);
        file.mkdirs();
        file = new File(file, table_name + "Controller.java");
        output = new FileOutputStream(file);
        output.write(FtlUtil.getFtl("templates/code_control.ftl", root).getBytes());
        output.flush();
        output.close();
    }

    @Test
    public void test() {
        try {
            generateCode("E:\\Downloads\\project\\spring-demo\\spring-job-demo", "com/yolo", "", "Picture");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
