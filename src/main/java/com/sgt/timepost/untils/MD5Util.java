package com.sgt.timepost.untils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5Util {
    public static String md5(String src){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output=md.digest(src.getBytes());
            String ret = Base64.encodeBase64String(output);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
