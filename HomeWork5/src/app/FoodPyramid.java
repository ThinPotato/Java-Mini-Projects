package app;

import java.util.Scanner;

public class FoodPyramid {
    static private OrganismTree tree;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the Apex predator?");
        String in = scan.nextLine();
        tree = new OrganismTree(new OrganismNode(in));
        System.out.println("Is the organism an herbivore / a carnivore / an omnivore? (H / C / O): ");
        in = scan.nextLine();
        if (in.equals("H"))
            tree.root.setHerbivore(true);
        else if (in.equals("C"))
            tree.root.setCarnivore(true);
        else if (in.equals("O")) {
            tree.root.setCarnivore(true);
            tree.root.setHerbivore(true);
        }
        do {
            in = scan.nextLine();
            printMenu();
            if (in.equalsIgnoreCase("PC")) {
                // TODO: Create New Plat Child
            } else if (in.equalsIgnoreCase("AC")) {
                // TODO: Create new animal child
            } else if (in.equalsIgnoreCase("RC")) {
                // TODO: Remove Child
            } else if (in.equalsIgnoreCase("P")) {
                // TODO: Print out the cursor's prey
            } else if (in.equalsIgnoreCase("C")) {
                // TODO: Print out food chain
            } else if (in.equalsIgnoreCase("F")) {
                // TODO: Print out food pyramid at cursor
            } else if (in.equalsIgnoreCase("LP")) {
                // TODO: List all plants supporting Cursor
            } else if (in.equalsIgnoreCase("R")) {
                // TODO: reset cursor to root
            } else if (in.equalsIgnoreCase("M")) {
                // TODO: Move cursor to child
            }
        } while (!in.equalsIgnoreCase("q"));
    }

    public static void printMenu() {
        System.out.println(
                "(PC) -  Create New Plant Child\n(AC) - Create New Animal Child\n(RC) - Remove Child\n(P) - Print Out Cursor’s Prey\n(C) - Print Out Food Chain\n(F) - Print Out Food Pyramid at Cursor\n(LP) - List All Plants Supporting Cursor\n(R) - Reset Cursor to Root\n(M) - Move Cursor to Child\n(Q) - Quit");
    }
}