/**
 * Block
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.util.Scanner;

public class PlayfairEncryptionEngine {
    static Phrase phrase = new Phrase();
    static Phrase encrypted = new Phrase();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";
        System.out.println("Enter key phrase: ");
        KeyTable keyTable = KeyTable.buildFromString(scan.nextLine().replaceAll("[^a-zA-Z]", ""));

        do {
            printMenu();
            in = scan.nextLine();
            if (in.equalsIgnoreCase("CK")) {
                System.out.println("Enter key phrase: ");
                keyTable = KeyTable.buildFromString(scan.nextLine().replaceAll("[^a-zA-Z]", ""));
            } else if (in.equalsIgnoreCase("Pk")) {
                System.out.println(keyTable.toString());

            } else if (in.equalsIgnoreCase("EN")) {
                System.out.println("Plese enter a phrase to encrypt: ");
                phrase = Phrase.buildPhraseFromStringForEncryption(scan.nextLine().replaceAll("[^a-zA-Z]", ""));
                encrypted = phrase.encrypt(keyTable);
                System.out.println("encrypted text is: " + encrypted.toString());
            } else if (in.equalsIgnoreCase("DE")) {
                System.out.println("Please enter a phrase to decrypt: ");
                phrase = Phrase.buildPhraseFromStringForEncryption(scan.nextLine().replaceAll("[^a-zA-Z]", ""));

                System.out.println("decrypted text is: " + phrase.decrypt(keyTable).toString());
            }
        } while (!in.equalsIgnoreCase("q"));
        scan.close();
    }

    public static void printMenu() {
        System.out.println(
                "Menu:\n(CK) - Change key \n(PK) -  Print key \n(EN) -  Encrypt\n(DE) - Decrypt\n (Q) -  Quit\n\nPlease select an option: ");
    }
}