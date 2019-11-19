/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class TextAnalyzer {
    static ArrayList<Passage> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";
        System.out.println("Enter the directory of a folder of text files: ");
        in = scan.nextLine();
        File[] directoryOfFiles = new File(in).listFiles();
        list = new ArrayList<Passage>();
        for (File i : directoryOfFiles) {
            list.add(new Passage(i.getName(), i));
        }
        System.out.println("Passage added");

        for (Passage i : list) {
            for (int k = 0; k < list.size(); k++) {
                if (!i.title.equals(list.get(k).title))
                    Passage.cosineSimilarity(i, list.get(k));
            }
        }
        System.out.println("similarities processed.");
        for (Passage i : list) {
            String temp[] = i.toString().replaceAll("\\{|\\}", "").split(", ");
            // System.out.println(i.toString());
            System.out.printf("%s", i.getTitle() + ": ");
            for (int k = 0; k < temp.length; k++) {
                System.out.printf("%s", temp[k] + ", ");
            }
            System.out.println("\n");
        }

    }
}