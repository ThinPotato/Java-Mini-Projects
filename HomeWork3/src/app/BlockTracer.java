package app;

import java.io.File;
import java.util.*;

public class BlockTracer {
    Stack<Block> stack = new Stack<Block>();
    static String currentLine;

    public static void main(String[] args) throws Exception {
        trace();

    }

    public static void trace() throws Exception {

        File file = new File("src/app/sample1.c");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.charAt(i) == '}') {

                }
            }
        }
        sc.close();
    }
}