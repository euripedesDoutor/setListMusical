package com.doutor.setListMusical.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilMethods {

    public static String encriptar(String senha) throws UnsupportedEncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // "MD5"

            md.update(senha.getBytes());
            return converterParaHexa(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String converterParaHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
}
