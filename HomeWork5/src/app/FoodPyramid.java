package app;

import java.util.Scanner;

public class FoodPyramid {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        do {
            printMenu();
        } while (!in.equalsIgnoreCase("q"));
    }

    public static void printMenu() {
        System.out.println(
                "(PC) -  Create New Plant Child\n(AC) - Create New Animal Child\n(RC) - Remove Child\n(P) - Print Out Cursor’s Prey\n(C) - Print Out Food Chain\n(F) - Print Out Food Pyramid at Cursor\n(LP) - List All Plants Supporting Cursor\n(R) - Reset Cursor to Root\n(M) - Move Cursor to Child\n(Q) - Quit");
    }
}