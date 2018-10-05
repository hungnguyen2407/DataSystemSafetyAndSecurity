package cryptography;

public interface Cryptography {
    /**
     * Encrypt a plain text to cipher text
     *
     * @param plainText: the plain text to encrypt
     * @param key:       the key use to encrypt
     */
    String encrypt(String plainText, String key);

    /**
     * Decrypt a cipher text to plain text
     *
     * @param cipherText: the cipher text to decrypt
     * @param key:        the key use to decrypt
     */
    String decrypt(String cipherText, String key);

}
