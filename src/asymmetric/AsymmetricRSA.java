package asymmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class AsymmetricRSA {

    private static PrivateKey privateKey;

    private static PublicKey publicKey;

    private static void keyPairInit() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("AsymmetricRSA.keyPairInit: " + e.getMessage());
        }

        KeyPair keyPair = null;
        if (keyPairGenerator != null) {
            keyPair = keyPairGenerator.generateKeyPair();
        }

        if (keyPair != null) {
            privateKey = keyPair.getPrivate();
        }
        if (keyPair != null) {
            publicKey = keyPair.getPublic();
        }
    }

    private static byte[] encrypt(byte[] plainText, PublicKey publicKey) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            System.out.println("AsymmetricRSA.encrypt: " + e.getMessage());
        }
        try {
            if (cipher != null) {
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            }
        } catch (InvalidKeyException e) {
            System.out.println("AsymmetricRSA.encrypt: " + e.getMessage());
        }

        try {
            if (cipher != null) {
                return cipher.doFinal(plainText);
            }
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("AsymmetricRSA.encrypt: " + e.getMessage());
        }

        return null;
    }

    private static byte[] decrypt(byte[] cipherText, PrivateKey privateKey) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            System.out.println("AsymmetricRSA.decrypt: " + e.getMessage());
        }
        try {
            if (cipher != null) {
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
            }
        } catch (InvalidKeyException e) {
            System.out.println("AsymmetricRSA.decrypt: " + e.getMessage());
        }

        try {
            if (cipher != null) {
                return cipher.doFinal(cipherText);
            }
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("AsymmetricRSA.decrypt: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        keyPairInit();

        byte[] plainText = "This is a plain text example for using asymmetric (RSA) cryptography".getBytes();

        keyPairInit();

        byte[] cipherText = encrypt(plainText, publicKey);
        if (cipherText != null) {
            System.out.println(new String(cipherText));
        }

        plainText = decrypt(cipherText, privateKey);
        if (plainText != null) {
            System.out.println(new String(plainText, StandardCharsets.UTF_8));
        }
    }
}
