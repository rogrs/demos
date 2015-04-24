package br.com.demos.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import br.com.demos.vo.Usuarios;

//http://viralpatel.net/blogs/java-md5-hashing-salting-password/
//http://viralpatel.net/blogs/java-read-write-csv-file/

public class Owasp {

    private static final Logger logger = Logger.getLogger(Owasp.class);
    private final static int ITERATION_NUMBER = 1000;

    public Owasp() {
    }

    public static byte[] getHash(int iterationNb, String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(salt);
        byte[] input = null;
        try {
            input = digest.digest(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("Erro getHash input " + input, e);
        }
        for (int i = 0; i < iterationNb; i++) {
            digest.reset();
            input = digest.digest(input);
        }
        return input;
    }

    public static byte[] base64ToByte(String data) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(data);
    }

    public static String byteToBase64(byte[] data) {
        BASE64Encoder endecoder = new BASE64Encoder();
        return endecoder.encode(data);
    }

    public static String decode(String s) {
        return StringUtils.newStringUtf8(Base64.decodeBase64(s));
    }

    public static String encode(String s) {
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(s));
    }

    public static Usuarios generateHash(Usuarios entity) {

        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {

            logger.error("Erro gerar random " + random, e);
        }
        byte[] bSalt = new byte[8];
        random.nextBytes(bSalt);

        byte[] bDigest = null;
        try {
            bDigest = getHash(ITERATION_NUMBER, entity.getPwd(), bSalt);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Erro generateHash bDigest " + bDigest, e);
        }
        String sDigest = byteToBase64(bDigest);
        String sSalt = byteToBase64(bSalt);

        entity.setPwd(sDigest);
        entity.setSalt(sSalt);
        return entity;
    }

}
