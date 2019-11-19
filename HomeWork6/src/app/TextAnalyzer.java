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

        for (Passage i : list) {
            for (int k = 0; k < list.size(); k++) {
                if (!i.title.equals(list.get(k).title))
                    Passage.cosineSimilarity(i, list.get(k));
            }
        }

        for (Passage i : list) {
            System.out.println(i.toString());
        }

    }
}