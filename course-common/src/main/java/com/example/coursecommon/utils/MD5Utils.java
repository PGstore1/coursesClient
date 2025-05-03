package com.example.coursecommon.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

    /**
     * 对字符串进行MD5加密
     *
     * @param input 原始字符串
     * @return 加密后的MD5值（32位小写字符串）
     */
    public static String encrypt(String input) {
        try {
            // 创建MD5哈希对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算哈希值
            byte[] hashBytes = md.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5算法不支持", e);
        }
    }

    public static void main(String[] args) {
        String input = "123456";
        String md5Result = MD5Utils.encrypt(input);
        System.out.println("原始字符串: " + input);
        System.out.println("MD5加密结果: " + md5Result);
    }
}

