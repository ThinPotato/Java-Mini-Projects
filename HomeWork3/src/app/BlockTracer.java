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
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.substring(i, i + 1).equals("{")) {
                    System.err.println("new block made.");
                    stack.push(new Block());
                }
                if (currentLine.substring(i, i + 1).equals("}")) {
                    System.err.println("stack popped.");
                    stack.pop();
                }
                if (currentLine.length() >= i + 4 && currentLine.substring(i, i + 4).equals("int ")) {
                    // TODO: create varialbe in highest block.
                    newVariable(i);
                }
                if (currentLine.length() >= i + 8 && currentLine.substring(i, i + 8).equals("/*$print")) {
                    currentLine = currentLine.substring(i);
                    print();
                }
            }
        }
        sc.close();
    }

    public static void print() {
        currentLine = currentLine.replace("*/", "");
        currentLine = currentLine.replace("/*$", "");
        String[] trimmed = currentLine.split(" ");
        if (trimmed[1].equals("LOCAL")) {
            System.out.println("found local " + stack.peek().toString());
        } else {
            // if variable exists in first block
            for (int i = 0; i < getSize(); i++) {
                if (getAt(i).findVarialbe(trimmed[1]) != null) {
                    System.out.println("FOUND: " + getAt(i).findVarialbe(trimmed[1]).getName() + ":"
                            + getAt(i).findVarialbe(trimmed[1]).getIntegerValue());
                    break;
                }
            }
        }

    }

    public static Block getAt(int index) {
        Stack<Block> tempStack = new Stack<Block>();
        Stack<Block> backup = (Stack<Block>) stack.clone()
        Block temp = new Block();
        while (!backup.empty()) {
            tempStack.push(backup.pop());
        }
        for (int i = 0; i < index; i++) {
            temp = tempStack.pop();
        }
        return temp;
    }

    public static int getSize() {
        Stack<Block> backup = (Stack<Block>) stack.clone();
        int count = 0;
        while (!backup.empty()) {
            backup.pop();
            count++;
        }
        return count;
    }

    public static void newVariable(int startingPoint) {
        String name = "";
        int value = 0;
        String trimmedLine = "";
        String trimmed[];
        int i = 0;
        try {
            // add spaces after operators
            trimmedLine = currentLine.replace(",", " ,");
            trimmedLine = trimmedLine.replaceAll(";", " ;");
            trimmed = trimmedLine.split(" ");

            while (!trimmed[i].equals(";")) {
                if (trimmed[i].equals(",") || trimmed[i].equals("int")) {
                    name = trimmed[i + 1];
                    if (trimmed[i + 2].equals("="))
                        value = Integer.parseInt(trimmed[i + 3]);
                    else
                        value = 0;
                    stack.peek().addVariable(name, value);
                }
                i++;
            }

        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
        }
    }
}