package app;

import java.util.Scanner;

public class FollowGraphDriver {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        while (!in.equalsIgnoreCase("q")) {
            System.out.println(
                    "(U) Add User \n (c) Add Connection \n (AU) load all users \n (AC) Load all connections \n (P) Print all Users \n (SA) Sort by user Name \n (SB) Sort by User followers \n (SC) Sort by User following \n (Q) quit \n (L) print (L) print all loops \n (RU) remove User \n (RC) Remove Connection \n (SP) Find shortest path \n (AP) Find all paths \n (Q) Quit");
        }
    }
}