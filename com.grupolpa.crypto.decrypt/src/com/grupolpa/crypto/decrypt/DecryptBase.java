package com.grupolpa.crypto.decrypt;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import sun.misc.BASE64Decoder;

/**
 * Permite encriptar y desencriptar una cadena
 *
 * @author Juan Pulido <jpulido@grupolpa.com>
 * @version 1.0 27/05/2012
 * @company LPA Corporate Solutions
 */
public class DecryptBase {

    private String algorithm;
    private SecretKey secretKey;
    private byte[] secret = {1, 2, 3, 4, 5, 6, 7, 8};

    public DecryptBase() {
    }

    /**
     * Permite desencriptar una cadena
     *
     * @param stringToDecrypt cadena para desencriptar
     * @return cadena desencriptado
     */
    public String decrypt(String stringToDecrypt) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String decryptedString = "";
        try {
            byte dec[] = (new BASE64Decoder()).decodeBuffer(stringToDecrypt);

            Cipher descifrar = Cipher.getInstance(algorithm);

            descifrar.init(Cipher.DECRYPT_MODE, secretKey);

            byte cadenaByte[] = descifrar.doFinal(dec);

            decryptedString = new String(cadenaByte, "UTF8");

        } catch (IOException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        }

        return decryptedString;

    }

    /**
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * @param algorithm the algorithm to set
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * @return the secretKey
     */
    public SecretKey getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey the secretKey to set
     */
    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * @return the secret
     */
    public byte[] getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(byte[] secret) {
        this.secret = secret;
    }
}
