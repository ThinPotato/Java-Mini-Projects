/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.util.Collections;
import java.util.Scanner;

public class FollowGraphDriver {
    public static FollowGraph graph = new FollowGraph();

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        printMenu();
        while (!in.equalsIgnoreCase("q")) {
            printMenu();
            in = scan.nextLine();
            if (in.equalsIgnoreCase("U")) {
                System.out.println("What name?");
                String name = scan.nextLine();
                graph.addUser(name);
                System.err.println("Successfully addded " + name);
            } else if (in.equalsIgnoreCase("C")) {
                String source;
                String dest;
                System.out.println("Please enter the source:");
                source = scan.nextLine();
                System.out.println("Please enter dest");
                dest = scan.nextLine();
                graph.addConnection(source, dest);
            } else if (in.equalsIgnoreCase("AU")) {
                System.out.println("Enter the file name:");

            } else if (in.equalsIgnoreCase("AC")) {
                System.out.println("Enter the file name:");

            } else if (in.equalsIgnoreCase("P")) {
                System.out.println("How would you like them sorted? SA, SB, SC");
                in = scan.nextLine();
                if (in.equalsIgnoreCase("SA")) {
                    Collections.sort(graph.getUsers(), new NameComparator());
                    System.out.println(graph.getUsers().toString());
                } else if (in.equalsIgnoreCase("SB")) {
                    Collections.sort(graph.getUsers(), new FollowersComparator());
                    System.out.println(graph.getUsers().toString());
                } else if (in.equalsIgnoreCase("SC")) {
                    Collections.sort(graph.getUsers(), new FollowingComparator());
                    System.out.println(graph.getUsers().toString());
                } else if (in.equalsIgnoreCase("Q")) {
                    printMenu();
                } else {
                    System.out.println("ERROR: not a valid sorting method");
                }
            } else if (in.equalsIgnoreCase("L")) {
                // graph.findAllLoops();
            } else if (in.equalsIgnoreCase("RU")) {
                // TODO: THIS
                System.out.println("Please enter the user to remove: ");
            } else if (in.equalsIgnoreCase("RC")) {
                String a;
                String b;
                System.out.println("Please enter the source of the connection to remove:");
                a = scan.nextLine();
                System.out.println("Please enter the dest of the connection to remove:");
                b = scan.nextLine();
                graph.removeConnection(a, b);
            } else if (in.equalsIgnoreCase("SP")) {
                String a;
                String b;
                System.out.println("Please enter the desired source:");
                a = scan.nextLine();
                System.out.println("Please enter the desired destination ");
                b = scan.nextLine();
                graph.shortestPath(a, b);
            } else if (in.equalsIgnoreCase("AP")) {
                String a;
                String b;
                System.out.println("Please enter the desired source:");
                a = scan.nextLine();
                System.out.println("Please enter the desired destination ");
                b = scan.nextLine();
                graph.printPaths(a, b);

            }
        }
    }

    private static void printMenu() {
        System.out.println(
                "(U) Add User \n (c) Add Connection \n (AU) load all users \n (AC) Load all connections \n (P) Print all Users \n (SA) Sort by user Name \n (SB) Sort by User followers \n (SC) Sort by User following \n (Q) quit \n (L) print (L) print all loops \n (RU) remove User \n (RC) Remove Connection \n (SP) Find shortest path \n (AP) Find all paths \n (Q) Quit");

    }
}