package cryptography;

import java.util.Scanner;

public class Ultitilies {

    public static void InputHandler(Cryptography cryptography) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            String key;
            String plainText;
            key = sc.nextLine();
            plainText = sc.nextLine();

            result.append(cryptography.encrypt(plainText, key)).append("\n");
        }
        System.out.println(result.toString());
    }
}
