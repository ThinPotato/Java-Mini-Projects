package app;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.nio.file.*;

class Passage {
    String title;
    int wordCount;
    Hashtable<String, Double> similarTitles = new Hashtable<String, Double>();
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    File stopWordsFile = new File(
            "A:\\Users\\bryce\\Documents\\Development\\CSE214\\HomeWork6\\src\\app\\Stopwords.txt");
    String stopWords[];

    public Passage(String title, File file) {
        this.title = title;
        parseFile(file);
    }

    public void processStopWords() {
        String content = "";
        try {
            content = new String(Files.readAllBytes(stopWordsFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopWords = content.split("\\r?\\n");
    }

    public static double cosineSimilarity(Passage passage1, Passage passage2) {
        double top = 0;
        double bot1 = 0;
        double bot2 = 0;
        double finalanswer = 0;
        // String words[] = ((passage1.wordCount > passage2.wordCount) ?
        // passage1.getWords().toArray(new String[0])
        // : passage2.getWords().toArray(new String[0]));
        String words[] = passage1.getWords().toArray(new String[0]);

        for (int i = 0; i < words.length; i++) {
            top += (passage1.getWordFrequency(words[i]) * passage2.getWordFrequency(words[i]));
            bot1 += (Math.pow((passage1.getWordFrequency(words[i])), 2));
            bot2 += (Math.pow((passage2.getWordFrequency(words[i])), 2));
        }
        finalanswer = 100 * ((top) / (Math.sqrt(bot1) * Math.sqrt(bot2)));

        passage1.similarTitles.put(passage2.getTitle(), finalanswer);
        passage2.similarTitles.put(passage1.getTitle(), finalanswer);
        return finalanswer;
    }

    public void parseFile(File file) {
        processStopWords();
        String content = "";
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] parsedFile = content.replaceAll("[^A-Za-z0-9\\s]", "").toLowerCase().split(" ");
        String[] TEST = stopWords;

        for (int i = 0; i < parsedFile.length; i++) {
            for (int k = 0; k < stopWords.length; k++) {
                if ((parsedFile[i].equals(stopWords[k]))) {
                    parsedFile[i] = "";
                }
            }
            if (!parsedFile[i].equals("")) {
                wordCount++;
                if (table.get(parsedFile[i]) != null && table.get(parsedFile[i]) > 0)
                    table.replace(parsedFile[i], table.get(parsedFile[i]) + 1);
                else
                    table.put(parsedFile[i], 1);
            }
        }
    }

    public double getWordFrequency(String word) {
        if (table.get(word) == null)
            return 0;
        // System.out.println(table.get(word));
        // System.out.println((double) table.get(word) / wordCount);
        return (double) table.get(word) / wordCount;
    }

    public Set<String> getWords() {
        return table.keySet();
    }

    public String getTitle() {
        return title;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Hashtable<String, Double> getSimilarTitles() {
        return similarTitles;
    }

    public void setSimilarTitles(Hashtable<String, Double> similarTitles) {
        this.similarTitles = similarTitles;
    }

    @Override
    public String toString() {
        return similarTitles.toString();
    }
}
