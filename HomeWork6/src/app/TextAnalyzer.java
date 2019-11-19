package app;

import java.io.File;
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";
        System.out.println("Enter the directory of a folder of text files: ");
        in = scan.nextLine();
        File[] directoryOfFiles = new File(in).listFiles();
        FrequencyTable mainTable = new FrequencyTable();

        for (File i : directoryOfFiles) {
            mainTable.addPassage(new Passage(i.getName(), i));
        }
    }
}