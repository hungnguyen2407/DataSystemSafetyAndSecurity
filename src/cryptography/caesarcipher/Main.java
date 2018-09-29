package cryptography.caesarcipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the plaint text you want to encrypt.");

        String plainText = "";
        if(sc.hasNext())
        {
            plainText = sc.nextLine();
        }

        System.out.println("Input the step to move the character.");
        int moveStep = 0;
        if(sc.hasNext())
        {
            moveStep = sc.nextInt();
        }

        new CaesarCipher().encrypting(plainText, moveStep);
    }
}
