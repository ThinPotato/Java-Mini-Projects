package app;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;

class Passage {
    String title;
    int wordCount;
    Hashtable<String, Double> similarTitles = new Hashtable<String, Double>();
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    String[] stopWords = new File("/home/bryce/Development/CSE214/HomeWork6/src/app/Stopwords.txt").toString()
            .split("\\r?\\n");

    public Passage(String title, File file) {
        this.title = title;
        parseFile(file);
    }

    public void parseFile(File file) {
        // TODO: implement method
        String[] parsedFile = file.toString().replaceAll("[^A-Za-z0-9]", "").toLowerCase().split(" ");
        for (int i = 0; i < parsedFile.length; i++) {
            for (int k = 0; k < stopWords.length; k++) {
                if (!parsedFile[i].equals(stopWords[k])) {
                    wordCount++;
                    if (table.get(parsedFile[i]) > 0)
                        table.replace(parsedFile[i], table.get(parsedFile[i]) + 1);
                    else
                        table.put(parsedFile[i], 1);
                }
            }
        }
    }

    public double getWordFrequency(String word) {
        return table.get(word) / wordCount;
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
        return super.toString();
    }
}
