/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupolpa.crypto.decrypt;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Permite encriptar y desencriptar una cadena
 *
 * @author Juan Pulido <jpulido@grupolpa.com>
 * @version 1.0 27/05/2012 @company LPA Corporate Solutions
 */
public class Decrypt  {

    
    /**
     * Permite desencriptar una cadena
     *
     * @param cadenaParaDesencriptar cadena para desencriptar
     * @return cadena desencriptado
     */
    public static String decrypt(String stringToDecrypt) throws Exception {
        String cadenaDesencriptado;

        DecryptBase decryptBase = new DecryptBase();

        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey key = skf.generateSecret(new DESKeySpec(decryptBase.getSecret()));
        decryptBase.setSecretKey(key);
        decryptBase.setAlgorithm("DES");
        cadenaDesencriptado = decryptBase.decrypt(stringToDecrypt);


        return cadenaDesencriptado;
    }
}
