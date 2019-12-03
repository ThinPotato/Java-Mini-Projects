package app;

import java.util.Scanner;

public class FollowGraphDriver {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        while (!in.equalsIgnoreCase("q")) {
            printMenu();
            in = scan.nextLine();
            if (in.equalsIgnoreCase("U")) {

            } else if (in.equalsIgnoreCase("C")) {

            } else if (in.equalsIgnoreCase("AU")) {

            } else if (in.equalsIgnoreCase("AC")) {

            } else if (in.equalsIgnoreCase("P")) {
                System.out.println("How would you like them sorted? SA, SB, SC");
                in = scan.nextLine();
                if (in.equalsIgnoreCase("SA")) {

                } else if (in.equalsIgnoreCase("SB")) {

                } else if (in.equalsIgnoreCase("SC")) {

                } else if (in.equalsIgnoreCase("Q")) {

                } else {
                    System.out.println("ERROR: not a valid sorting method");
                }
            } else if (in.equalsIgnoreCase("L")) {

            } else if (in.equalsIgnoreCase("RU")) {

            } else if (in.equalsIgnoreCase("RC")) {

            } else if (in.equalsIgnoreCase("SP")) {

            } else if (in.equalsIgnoreCase("AP")) {
        }
    }

    private static void printMenu() {
        System.out.println(
                "(U) Add User \n (c) Add Connection \n (AU) load all users \n (AC) Load all connections \n (P) Print all Users \n (SA) Sort by user Name \n (SB) Sort by User followers \n (SC) Sort by User following \n (Q) quit \n (L) print (L) print all loops \n (RU) remove User \n (RC) Remove Connection \n (SP) Find shortest path \n (AP) Find all paths \n (Q) Quit");

    }
}