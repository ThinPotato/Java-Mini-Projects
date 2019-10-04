package app;

import java.io.File;
import java.util.Scanner;

public class BlockTracer {
    public static void main(String[] args) throws Exception {
        trace();

    }

    public static void trace() throws Exception {

        File file = new File("src/app/sample1.c");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}