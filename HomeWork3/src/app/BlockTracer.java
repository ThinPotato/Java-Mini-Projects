package app;

import java.io.File;
import java.util.*;

public class BlockTracer {
    static Stack<Block> stack = new Stack<Block>();
    static String currentLine;

    public static void main(String[] args) throws Exception {
        trace();

    }

    public static void trace() throws Exception {

        File file = new File("src/app/sample1.c");
        Scanner sc = new Scanner(file);
        Block block = new Block();
        ;
        stack.add(block);
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            if (currentLine.contains("{")) {
                System.out.println("{ found");
            }
            if (currentLine.contains("int")) {
                int intIndex = currentLine.indexOf("int ");
                String[] lineSplit = currentLine.split(" ");
                for (int i = 0; i < lineSplit.length; i++) {
                    System.out.println(lineSplit[i]);

                    if (lineSplit[i].equals("=")) {
                        block.addVariable(lineSplit[i + 1], Integer.parseInt(lineSplit[i + 2]));
                        if (lineSplit[i + 3].equals(",")) {

                        }
                    }
                }

                // block.addVariable(location, name, data);
            }
            if (currentLine.contains("/*$print")) {
                System.out.println("print found");
            }
            if (currentLine.contains("}")) {
                System.err.println("} found");
            }
        }
        sc.close();
    }
}