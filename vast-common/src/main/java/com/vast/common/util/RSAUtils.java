package com.vast.common.util;

import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
public class RSAUtils {
    private static final String RSA="RSA";
    private static final int KEY_SIZE=1024;

    public static KeyPair generateKeyPair(String password) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            SecureRandom secureRandom = new SecureRandom(password.getBytes());
            keyPairGenerator.initialize(KEY_SIZE, secureRandom);
            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
