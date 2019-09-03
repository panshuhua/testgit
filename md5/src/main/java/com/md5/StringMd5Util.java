package com.md5;

import org.springframework.util.DigestUtils;

/**
 * 在Spring框架下的MD5加密
 * 
 * @author panshuhua
 * @date 2019/07/29
 */
public class StringMd5Util {
    /**
     * 将一个字符串MD5加密，方式很多，我们使用的是Spring包下
     * 
     * @param password
     * @return
     */
    public static String getMd5Simple(String password) {
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md5;
    }

    /**
     * 原密码加密一次；获取原密码加密后前8位字符+加密后的字符串；再加密一次
     */
    public static String getMd5(String password) {
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        String temp = md5.substring(0, 8);
        md5 = DigestUtils.md5DigestAsHex((temp + md5).getBytes());
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(getMd5Simple("12345"));
        System.out.println(getMd5("12345"));
    }

}
