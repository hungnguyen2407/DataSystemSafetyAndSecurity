package DigitalSignature;

import java.security.*;

public class DigitalSignatureDSA {

    private static PrivateKey privateKey;

    private static PublicKey publicKey;

    private static void keyPairInit() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA", "SUN");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        privateKey = keyPair.getPrivate();

        publicKey = keyPair.getPublic();

    }

    private static byte[] sign(byte[] data, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "SUN");

        sign.initSign(privateKey);

        sign.update(data);

        return sign.sign();


    }

    private static boolean verify(byte[] data, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sign = Signature.getInstance("SHA1withDSA", "SUN");
        sign.initVerify(publicKey);
        sign.update(data);
        return sign.verify(signature);
    }

    public static void main(String[] args) throws Exception {
        keyPairInit();

        byte[] data = "This is a plain text example for using asymmetric (DSA) cryptography".getBytes();

        byte[] signature = sign(data, privateKey);


        System.out.println(new String(signature));

        System.out.println(verify(data, signature, publicKey));

    }
}
