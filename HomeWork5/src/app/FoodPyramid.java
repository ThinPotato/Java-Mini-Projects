package app;

import java.util.Scanner;

public class FoodPyramid {
    static OrganismTree tree;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the Apex predator?");
        String in = scan.nextLine();
        tree = new OrganismTree(new OrganismNode(in));
        System.out.println("Is the organism an herbivore / a carnivore / an omnivore? (H / C / O): ");
        do {
            printMenu();
        } while (!in.equalsIgnoreCase("q"));
    }

    public static void printMenu() {
        System.out.println(
                "(PC) -  Create New Plant Child\n(AC) - Create New Animal Child\n(RC) - Remove Child\n(P) - Print Out Cursor’s Prey\n(C) - Print Out Food Chain\n(F) - Print Out Food Pyramid at Cursor\n(LP) - List All Plants Supporting Cursor\n(R) - Reset Cursor to Root\n(M) - Move Cursor to Child\n(Q) - Quit");
    }
}