package symmetric;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;

public class SymmetricFileDES_CBC_PKCS5Padding {

    private static byte[] iv = new byte[8];
    private static IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    private static Key key;

    /**
     * Encrypt a plain text to cipher text
     *
     * @param fileSrc : the file source
     * @param fileDes : the file destination
     */
    static void encrypt(String fileSrc, String fileDes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        key = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
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
    static void decrypt(String fileSrc, String fileDes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

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

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, CertificateEncodingException, InvalidAlgorithmParameterException {

        System.out.println("Encrypt");
        encrypt("/Users/hungnguyen/Downloads/a.doc", "/Users/hungnguyen/Downloads/output.doc");
        System.out.println("Decrypt");
        decrypt("/Users/hungnguyen/Downloads/output.doc", "/Users/hungnguyen/Downloads/b.doc");

    }

}