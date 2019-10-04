package app;

import java.io.File;
import java.util.Scanner;

public class BlockTracer {
    public static void main(String[] args) {
        System.out.println("Hello!");

    }

    public static void trace() throws Exception {
        // pass the path to the file as a parameter
        File file = new File("test.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}