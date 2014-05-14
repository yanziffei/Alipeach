package com.alipeach.security;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Chen Haoming
 */
public class Md5EncryptorTest {

    @Test
    public void testEncrypt () {
        Md5Encryptor md5Encryptor = new Md5Encryptor ();
        String alipeach = md5Encryptor.encrypt ("Alipeach");
        Assert.assertEquals ("BBE7A583FC6D73FA7362B7C313C86D1D", alipeach);
    }
}
