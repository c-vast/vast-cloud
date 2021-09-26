package com.vast.common.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

/**
 * 对称加密解密帮助类 基于hutool封装
 */
public class AESUtils {

    /**
     *
     * @param content
     * @param key
     * @return
     */
    public static String encrypt(String content,String key){
        AES aes = createAES(key);
        return aes.encryptHex(content);
    }

    /**
     *
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content,String key){
        AES aes = createAES(key);
        return aes.decryptStr(content);
    }

    private static AES createAES(String key){
        return SecureUtil.aes(key.getBytes());
    }
}
