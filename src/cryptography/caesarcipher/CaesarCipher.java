package cryptography.caesarcipher;

import cryptography.Converter;
import cryptography.Cryptography;

/**
 * Caesar Cipher is an encryption method
 *
 * @see <a href="https://en.wikipedia.org/wiki/Caesar_cipher">Wikipedia</a>
 */
public class CaesarCipher implements Cryptography {

    /**
     * Encrypt a plain text to cipher text
     *
     * @param plainText : the plain text to encrypt
     * @param key       : the key use to encrypt
     */
    @Override
    public String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        char[] pt = plainText.toCharArray();
        for (char c : pt) {
            if (Character.isAlphabetic(c)) {
                cipherText.append(Converter.numberToAlphabet((Converter.alphabetToNumber(Character.toUpperCase(c)) + Integer.parseInt(key)) % 22));
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }

    /**
     * Decrypt a cipher text to plain text
     *
     * @param cipherText : the cipher text to decrypt
     * @param key        : the key use to decrypt
     */
    @Override
    public String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();
        char[] ct = cipherText.toCharArray();
        for (char c : ct) {
            if (Character.isAlphabetic(c)) {
                plainText.append(Converter.numberToAlphabet((Converter.alphabetToNumber(c) - Integer.parseInt(key)) % 22));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
}
