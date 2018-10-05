package cryptography.symmetricblockcipher;

import cryptography.Converter;
import cryptography.Cryptography;

public class SymmetricBlockCipher implements Cryptography {
    /**
     * Encrypt a plain text to cipher text
     *
     * @param plainText : the plain text to encrypt
     * @param key       : the key use to encrypt
     */
    @Override
    public String encrypt(String plainText, String key) {
        char[] k = key.toCharArray();
        char[] pt = plainText.toCharArray();
        StringBuilder cipherText = new StringBuilder();
        int odd = pt.length / k.length;
        for (int i = 0; i < odd; i++) {
            for (int j = 0; j < k.length; j++) {
                if (Character.isAlphabetic(pt[(i * k.length) + j])) {
                    cipherText.append(Converter.numberToAlphabet((Converter.alphabetToNumber(Character.toUpperCase(k[j])) + Converter.alphabetToNumber(Character.toUpperCase(pt[(i * k.length) + j]))) % 22));
                } else {
                    cipherText.append(pt[(i * k.length) + j]);
                }

            }
        }
        for (int i = 0; i < pt.length % k.length; i++) {
            if (Character.isAlphabetic(pt[(odd * k.length) + i])) {
                cipherText.append(Converter.numberToAlphabet((Converter.alphabetToNumber(Character.toUpperCase(k[i])) + Converter.alphabetToNumber(Character.toUpperCase(pt[(odd * k.length) + i]))) % 22));
            } else {
                cipherText.append(pt[(odd * k.length) + i]);
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
        return null;
    }
}
