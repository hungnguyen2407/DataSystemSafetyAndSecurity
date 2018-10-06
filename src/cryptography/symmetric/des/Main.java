package cryptography.symmetric.des;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;

public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, CertificateEncodingException {
        System.out.println("Encrypt");
        new EncryptFile().encrypt("", "", "");

        System.out.println("Decrypt");
        FileInputStream fis = new FileInputStream(new File(""));

        byte[] key = new byte[1024];
        int byteRead = fis.read(key);
        new EncryptFile().decrypt("", "", new SecretKeySpec(key, 0, byteRead, "DES"));
    }
}
