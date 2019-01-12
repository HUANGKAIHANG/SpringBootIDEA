package com.hkh.SpringBootIDEA.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroTests {
    public static void main(String[] args) {
        int hashInterations = 2;
        Object salt = "admin8d78869f470951332959580424d4bf4f";
//        Object salt = "admin100";
        Object credentials = "123456";
        String hashAlgorithmName = "MD5";
        Object simpleHash = new SimpleHash(hashAlgorithmName,credentials,salt,hashInterations);
        System.out.println("密文："+simpleHash);
    }
}
