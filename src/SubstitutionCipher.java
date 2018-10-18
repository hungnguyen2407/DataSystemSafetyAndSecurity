import java.util.ArrayList;
import java.util.Scanner;

public class SubstitutionCipher {

    /**
     * Encrypt a plain text to cipher text
     *
     * @param plainText : the plain text to encrypt
     * @param key       : the key use to encrypt
     */
    public static String encrypt(String plainText, String key) {
        char[] pt = plainText.toCharArray();
        char[] k = key.toCharArray();
        StringBuilder cipherText = new StringBuilder();
        for (char c : pt) {
            if (Character.isAlphabetic(c)) {
                cipherText.append(k[alphabetToNumber(Character.toUpperCase(c))]);
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
    public static String decrypt(String cipherText, String key) {
        char[] ct = cipherText.toCharArray();
        ArrayList<Character> k = new ArrayList<>();
        for (char c : key.toCharArray()) {
            k.add(c);
        }
        StringBuilder plainText = new StringBuilder();
        for (char c : ct) {
            if (Character.isAlphabetic(c)) {
                plainText.append(numberToAlphabet(k.indexOf(c)));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }

    /**
     * Convert Vietnamese alphabet to number
     */
    public static int alphabetToNumber(char character) {
        character = Character.toUpperCase(character);
        switch (character) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'G':
                return 5;
            case 'H':
                return 6;
            case 'I':
                return 7;
            case 'K':
                return 8;
            case 'L':
                return 9;
            case 'M':
                return 10;
            case 'N':
                return 11;
            case 'O':
                return 12;
            case 'P':
                return 13;
            case 'Q':
                return 14;
            case 'R':
                return 15;
            case 'S':
                return 16;
            case 'T':
                return 17;
            case 'U':
                return 18;
            case 'V':
                return 19;
            case 'X':
                return 20;
            case 'Y':
                return 21;
            default:
                return -1;
        }
    }

    /**
     * Convert number to Vietnamese alphabet
     */
    public static char numberToAlphabet(int number) {
        switch (number) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'G';
            case 6:
                return 'H';
            case 7:
                return 'I';
            case 8:
                return 'K';
            case 9:
                return 'L';
            case 10:
                return 'M';
            case 11:
                return 'N';
            case 12:
                return 'O';
            case 13:
                return 'P';
            case 14:
                return 'Q';
            case 15:
                return 'R';
            case 16:
                return 'S';
            case 17:
                return 'T';
            case 18:
                return 'U';
            case 19:
                return 'V';
            case 20:
                return 'X';
            case 21:
                return 'Y';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            String key;
            String plainText;
            key = sc.nextLine();
            plainText = sc.nextLine();

            result.append(encrypt(plainText, key)).append("\n");
        }
        System.out.println(result.toString());
    }
}
