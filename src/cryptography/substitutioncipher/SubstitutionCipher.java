package cryptography.substitutioncipher;

import cryptography.Converter;
import cryptography.Cryptography;

import java.util.ArrayList;

public class SubstitutionCipher implements Cryptography {

    /**
     * Encrypt a plain text to cipher text
     *
     * @param plainText : the plain text to encrypt
     * @param key       : the key use to encrypt
     */
    @Override
    public String encrypt(String plainText, String key) {
        char[] pt = plainText.toCharArray();
        char[] k = key.toCharArray();
        StringBuilder cipherText = new StringBuilder();
        for (char c : pt) {
            if (Character.isAlphabetic(c)) {
                cipherText.append(k[Converter.alphabetToNumber(Character.toUpperCase(c))]);
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
        char[] ct = cipherText.toCharArray();
        ArrayList<Character> k = new ArrayList<>();
        for (char c : key.toCharArray()) {
            k.add(c);
        }
        StringBuilder plainText = new StringBuilder();
        for (char c : ct) {
            if (Character.isAlphabetic(c)) {
                plainText.append(Converter.numberToAlphabet(k.indexOf(c)));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
}
