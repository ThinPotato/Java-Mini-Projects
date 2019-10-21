package app;

import java.util.Scanner;

public class PlayfairEncryptionEngine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";
        System.out.println("Enter key phrase: ");
        KeyTable.buildFromString(scan.nextLine());

        do {
            printMenu();
            in = scan.nextLine();
            if (in.equalsIgnoreCase("CK")) {

            } else if (in.equalsIgnoreCase("Pk")) {
                System.out.println("Hello");

            } else if (in.equalsIgnoreCase("EN")) {

            } else if (in.equalsIgnoreCase("DE")) {

            }
            in = scan.nextLine();
        } while (!in.equalsIgnoreCase("q"));
        scan.close();
    }

    public static void printMenu() {
        System.out.println(
                "Menu:\n(CK) - Change key \n(PK) -  Print key \n(EN) -  Encrypt\n(DE) - Decrypt\n (Q) -  Quit\n\nPlease select an option: ");
    }
}