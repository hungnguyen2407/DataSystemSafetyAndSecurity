
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
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, CertificateEncodingException {

        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(sc.nextLine());
        String key;
        String plainText;
        for (int i = 0; i < testCase; i++) {
            key = sc.nextLine();
            plainText = sc.nextLine();

            System.out.println(result.toString());
            System.out.println("Encrypt");
            new EncryptFile().encrypt("", "");
            System.out.println("Decrypt");
//            FileInputStream fis = new FileInputStream(new File(""));
//            byte[] key = new byte[1024];
//            int byteRead = fis.read(key);
            new EncryptFile().decrypt("", "", new SecretKeySpec(key.getBytes(), 0, key.length(), "DES"));
        }
    }
}

class KeyWriter {

    static void write(Key key, String keyDes) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(keyDes));
        fos.write(key.getEncoded());
    }
}

class EncryptFile {
    /**
     * Encrypt a plain text to cipher text
     *
     * @param fileDes : the file destination
     * @param keyDes  : the key destination
     */
    void encrypt(String fileDes, String keyDes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        Key key = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        FileInputStream fis = new FileInputStream(new File(""));
        FileOutputStream fos = new FileOutputStream(new File(fileDes));

        byte[] container = new byte[1024];
        int byteRead;

        while ((byteRead = fis.read(container)) != -1) {
            byte[] output = cipher.update(container, 0, byteRead);
            if (output != null) {
                fos.write(container);
            }
        }
        fos.write(cipher.doFinal());
        fos.flush();
        fis.close();
        fos.close();

        KeyWriter.write(key, keyDes);
    }

    /**
     * Decrypt a cipher text to plain text
     *
     * @param fileSrc : the file source
     * @param fileDes : the file destination
     * @param key:    the key
     */
    void decrypt(String fileSrc, String fileDes, SecretKeySpec key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream fis = new FileInputStream(new File(fileSrc));
        FileOutputStream fos = new FileOutputStream(new File(fileDes));

        byte[] container = new byte[1024];
        int byteRead;

        while ((byteRead = fis.read(container)) != -1) {
            byte[] output = cipher.update(container, 0, byteRead);
            if (output != null) {
                fos.write(container);
            }
        }
        fos.write(cipher.doFinal());
        fos.flush();
        fis.close();
        fos.close();
    }
}