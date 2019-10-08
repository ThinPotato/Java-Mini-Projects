/**
 * Main class
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu
 */
package app;

import java.io.File;
import java.util.*;

public class BlockTracer {
    static Stack<Block> stack = new Stack<Block>();
    static String currentLine;
    static int stackCount;

    public static void main(String[] args) throws Exception {
        String fileName = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of file without filetype: ");
        fileName = scan.nextLine();
        trace(fileName);

    }

    public static void trace(String fileName) throws Exception {
        System.out.println("Variable: Initial Value.");

        File file = new File("src/app/" + fileName + ".c");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.substring(i, i + 1).equals("{")) {
                    stack.push(new Block());
                    stackCount++;
                }
                if (currentLine.substring(i, i + 1).equals("}")) {
                    stack.pop();
                    stackCount--;
                }
                if (currentLine.length() >= i + 4 && currentLine.substring(i, i + 4).equals("int ")) {
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
        currentLine = currentLine.substring(currentLine.indexOf("/*$") + 1, currentLine.indexOf("*/"));
        currentLine = currentLine.replace("*/", "");
        currentLine = currentLine.replace("/*$", "");
        String[] trimmed = currentLine.split(" ");

        boolean found = false;
        if (trimmed[1].equals("LOCAL")) {
            if (stack.peek().toString() != "")
                System.out.println("found locally: " + stack.peek().toString());
            else
                System.out.println("No local variables found.");
        } else {
            // if variable exists in first block
            for (int i = stackCount - 1; i >= 0; i--) {
                if (getAt(i).findVarialbe(trimmed[1]) != null) {
                    System.out.println(getAt(i).findVarialbe(trimmed[1]).getName() + ": "
                            + getAt(i).findVarialbe(trimmed[1]).getIntegerValue());
                    found = true;
                    break;
                }
            }
            if (found == false)
                System.out.println("Could not find variable: " + trimmed[1]);
            found = true;
        }

    }

    /**
     * @return the block at location index in stack counting from bottom to top.
     * @param index the location of the block in the stack
     */
    public static Block getAt(int index) {
        Stack<Block> tempStack = new Stack<Block>();
        Block[] backup = new Block[stackCount];
        Block temp = new Block();
        int j = 0;
        while (!stack.empty()) {
            backup[j] = stack.peek();
            tempStack.push(stack.pop());
            j++;
        }
        for (int i = 0; i < index + 1; i++) {
            temp = tempStack.pop();
        }
        for (int k = backup.length - 1; k >= 0; k--) {
            stack.push(backup[k]);
        }
        return temp;
    }

    /**
     * @param startingPoint used to declare where the new variable should be pulled
     *                      from
     * @throws IndexOutOfBoundsException
     */
    public static void newVariable(int startingPoint) {
        String name = "";
        int value = 0;
        String trimmedLine = "";
        String trimmed[];
        int i = 0;
        try {
            // add spaces after operators
            trimmedLine = trimmedLine.substring(trimmedLine.indexOf("int") + 1);
            trimmedLine = currentLine.replace(",", " ,");
            trimmedLine = trimmedLine.replaceAll(";", " ;");
            for (int k = 1; k < trimmedLine.length() - 1; k++) {
                if (trimmedLine.substring(k, k + 1).equals("=") && (!trimmedLine.substring(k, k + 2).equals("= "))) {
                    trimmedLine = trimmedLine.replace("=", " = ");
                }

            }
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

        } catch (

        IndexOutOfBoundsException e) {
            // TODO: handle exception
        }
    }
}