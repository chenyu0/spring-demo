package com.yolo.utils;

import org.slf4j.Logger;

import java.security.MessageDigest;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/24
 * Time: 11:17
 */


public class MD5Util {
    private static Logger logger = LogUtil.getLogger("frame");

    public MD5Util() {
    }

    private static byte[] hash(byte[] bytes, byte[] salt, int hashIterations) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("md5");
        if (salt != null) {
            digest.reset();
            digest.update(salt);
        }

        byte[] hashed = digest.digest(bytes);
        int iterations = hashIterations - 1;

        for(int i = 0; i < iterations; ++i) {
            digest.reset();
            hashed = digest.digest(hashed);
        }

        return hashed;
    }

    private static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            String hex = Integer.toHexString(b[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toString());
        }

        return sb.toString();
    }

    public static String toMd5(byte[] b) {
        try {
            return toHexString(hash(b, (byte[])null, 1));
        } catch (Exception var2) {
            logger.error("生成Md5失败.", var2);
            return null;
        }
    }

    public static String toMd5(byte[] b, int times) {
        try {
            return toHexString(hash(b, (byte[])null, times));
        } catch (Exception var3) {
            logger.error("生成Md5失败.", var3);
            return null;
        }
    }

    public static String toMd5(byte[] b, byte[] salt, int times) {
        try {
            return toHexString(hash(b, salt, times));
        } catch (Exception var4) {
            logger.error("生成Md5失败.", var4);
            return null;
        }
    }

    public static boolean equal(String md5, byte[] src) {
        return md5.equals(toMd5(src));
    }
}
