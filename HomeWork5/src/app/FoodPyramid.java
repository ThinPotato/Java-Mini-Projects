package app;

import java.util.Scanner;

public class FoodPyramid {
    private static OrganismTree tree;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the Apex predator?");
        String in = scan.nextLine();
        tree = new OrganismTree(new OrganismNode(in));
        System.out.println("Is the organism an herbivore / a carnivore / an omnivore? (H / C / O): ");
        hco(tree.root, scan.nextLine());
        do {
            printMenu();
            in = scan.nextLine();
            if (in.equalsIgnoreCase("PC")) {
                // TODO: Create New Plant Child
                System.out.println("What is the name of the organism?: ");
                in = scan.nextLine();
                tree.addPlantChild(in);
                System.out.println(in + " has successfully been added as prey for the " + tree.getCursor().getName());
            } else if (in.equalsIgnoreCase("AC")) {
                // TODO: Create new animal child
                System.out.println("What is the name of the Organism?");
                String name = scan.nextLine();
                System.out.println("Is the organism an herbivore / a carnivore / an omnivore? (H / C / O):");
                in = scan.nextLine();
                if (in.equalsIgnoreCase("H"))
                    tree.addAnimalChild(name, true, false);
                else if (in.equalsIgnoreCase("C"))
                    tree.addAnimalChild(name, false, true);
                else if (in.equalsIgnoreCase("O")) {
                    tree.addAnimalChild(name, true, true);
                }
                System.out.println(
                        "A " + name + " has successfully been added as prey for the " + tree.getCursor().getName());
            } else if (in.equalsIgnoreCase("RC")) {
                // TODO: Remove Child
                System.out.println("What is the name of the organism to be removed?: ");
                in = scan.nextLine();
                tree.removeChild(in);
                System.out.println(
                        "A " + in + " has been successfully removed as prey for the " + tree.getCursor().getName());
            } else if (in.equalsIgnoreCase("P")) {
                // TODO: Print out the cursor's prey
                System.out.println(tree.listPrey());
            } else if (in.equalsIgnoreCase("C")) {
                // TODO: Print out food chain
                System.out.println(tree.listFoodChain());
            } else if (in.equalsIgnoreCase("F")) {
                // TODO: Print out food pyramid at cursor
                tree.printOrganismTree();
            } else if (in.equalsIgnoreCase("LP")) {
                // TODO: List all plants supporting Cursor
                System.out.println(tree.listAllPlants());

            } else if (in.equalsIgnoreCase("R")) {
                // TODO: reset cursor to root
                tree.cursorReset();
                System.out.println("Cursor successfully reset to root!");
            } else if (in.equalsIgnoreCase("M")) {
                // TODO: Move cursor to child
                System.out.println("Which child should the cursor be moved to?: ");
                in = scan.nextLine();
                tree.moveCursor(in);
                System.out.println("successfully moved to " + in);
            }
        } while (!in.equalsIgnoreCase("q"));
    }

    public static void hco(OrganismNode node, String in) {
        if (in.equals("H"))
            node.setHerbivore(true);
        else if (in.equals("C"))
            node.setCarnivore(true);
        else if (in.equals("O")) {
            node.setCarnivore(true);
            node.setHerbivore(true);
        }
    }

    public static void printMenu() {
        System.out.println(
                "(PC) -  Create New Plant Child\n(AC) - Create New Animal Child\n(RC) - Remove Child\n(P) - Print Out Cursor’s Prey\n(C) - Print Out Food Chain\n(F) - Print Out Food Pyramid at Cursor\n(LP) - List All Plants Supporting Cursor\n(R) - Reset Cursor to Root\n(M) - Move Cursor to Child\n(Q) - Quit");
    }
}