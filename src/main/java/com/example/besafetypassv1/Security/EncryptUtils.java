package com.example.besafetypassv1.Security;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.besafetypassv1.Constant.KEY_HMAC;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author stl_sdd_thavithong
 */
public class EncryptUtils {

    private static final Logger logger = LogManager.getLogger(EncryptUtils.class);

    public String encrypBasicBase64(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        sha.reset();
        sha.update(input.getBytes("UTF-8"));
        return Base64.encodeBase64String(sha.digest());
    }

    public static String encodeBase64(String inputString) {
        String ouput = null;
        try {
            java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
            ouput = encoder.encodeToString(inputString.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ouput;
    }

    public String decodeBase64(String encodeString) {
        String ouput = null;
        try {
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            ouput = new String(decoder.decode(encodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ouput;
    }

    public static String getSignature(@NotNull HashMap<String, String> params, String secretKey) {

        String[] signedFieldNames = params.get(KEY_HMAC.signed_field_names).split(",");
        StringBuilder dataToSign = new StringBuilder();
        String signature = null;

        int index = 1;
        for (String field : signedFieldNames) {
            dataToSign.append(field);
            dataToSign.append("=");
            dataToSign.append(params.get(field));
            if (index++ < signedFieldNames.length) {
                dataToSign.append(",");
            }
        }
        logger.info(dataToSign.toString());
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            signature = Base64.encodeBase64String(sha256_HMAC.doFinal(dataToSign.toString().getBytes()));
            logger.info( "logger getSignature : "+dataToSign.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return signature;
    }
    public static String getSignedFieldNames(HashMap<String, String> params) {
        StringBuilder fieldNames = new StringBuilder();
        Iterator iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            fieldNames.append(pair.getKey());
            if (iterator.hasNext()) {
                fieldNames.append(',');
            }
        }
        return fieldNames.toString();
    }
}
