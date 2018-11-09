package symmetric;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.util.Scanner;

public class SymmetricFileDES {
    private static Key key;
    /**
     * Encrypt a plain text to cipher text
     *
     * @param fileSrc : the key source
     * @param fileDes : the file destination
     */
    static void encrypt(String fileSrc, String fileDes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        key = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        FileInputStream fis = new FileInputStream(new File(fileSrc));
        FileOutputStream fos = new FileOutputStream(new File(fileDes));

        byte[] container = new byte[1024];
        int byteRead;

        while ((byteRead = fis.read(container)) != -1) {
            byte[] output = cipher.update(container, 0, byteRead);
            if (output != null) {
                fos.write(output);
            }
        }
        fos.write(cipher.doFinal());
        fos.flush();
        fis.close();
        fos.close();

    }

    /**
     * Decrypt a cipher text to plain text
     *
     * @param fileSrc : the file source
     * @param fileDes : the file destination
     */
    static void decrypt(String fileSrc, String fileDes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream fis = new FileInputStream(new File(fileSrc));
        FileOutputStream fos = new FileOutputStream(new File(fileDes));

        byte[] container = new byte[1024];
        int byteRead;

        while ((byteRead = fis.read(container)) != -1) {
            byte[] output = cipher.update(container, 0, byteRead);
            if (output != null) {
                fos.write(output);
            }
        }
        fos.write(cipher.doFinal());
        fos.flush();
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, CertificateEncodingException {

        System.out.println("Encrypt");
        encrypt("", "");
        System.out.println("Decrypt");
        decrypt("", "");
    }
}