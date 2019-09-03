package com.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * java自带的md5加密
 * 
 * @author panshuhua
 * @date 2019/07/29
 */
public class JavaMd5Util {
    public static String getMd5(byte[] source) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};// 用来将字节转换成16进制表示的字符
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16*2
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节转换成 16进制
                byte byte0 = tmp[i]; // 取第i个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高4位的数字转换，>>>为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低4位的数字转换
            }
            s = new String(str); // 转换后的结果转换位字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 原密码加密一次；获取原密码加密后前8位字符+加密后的字符串；再加密一次
     */
    public static String getMd5Str(String str) {
        String md5Str = getMd5(str.getBytes());
        String temp = md5Str.substring(0, 8);
        String md5 = getMd5((temp + md5Str).getBytes());
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(JavaMd5Util.getMd5("12345".getBytes()));
        System.out.println(getMd5Str("12345"));
    }

}
