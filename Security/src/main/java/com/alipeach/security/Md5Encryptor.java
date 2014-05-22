package com.alipeach.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Chen Haoming
 */
public class Md5Encryptor implements IrreversibleEncryptor {

    private MessageDigest messageDigest;

    private String charset = "utf-8";

    private String salt = "";

    public Md5Encryptor () {
        try {
            messageDigest = MessageDigest.getInstance ("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public String encrypt (String plaintext) {

        try {
            messageDigest.reset ();
            messageDigest.update ((plaintext + salt).getBytes (charset));
            byte[] result = messageDigest.digest ();

            StringBuilder stringBuilder = new StringBuilder ();

            for (byte b : result) {
                stringBuilder.append (String.format ("%02X", b));
            }

            return stringBuilder.toString ();
        } catch (Throwable e) {
            throw new RuntimeException (e);
        }
    }

    public void setCharset (String charset) {
        if (null == charset) {
            throw new NullPointerException ("Charset should never be null!");
        }
        this.charset = charset;
    }

    public void setSalt (String salt) {
        this.salt = salt;
    }
}
