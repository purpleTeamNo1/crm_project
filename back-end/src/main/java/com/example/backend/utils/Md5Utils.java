package com.example.backend.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Md5Utils {

    public static String md5Generator(String word) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(word.getBytes());
        byte[] digest = md.digest();
        //Another encoding with converting all alphabet to uppercase
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }
}
