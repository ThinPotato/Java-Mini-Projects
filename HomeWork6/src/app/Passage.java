package app;

import java.io.File;
import java.util.Hashtable;
import java.util.Set;

class Passage {
    String title;
    int wordCount;
    Hashtable<String, Double> similarTitles = new Hashtable<String, Double>();
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    String[] stopWords = new File(
            "A:\\Users\\bryce\\Documents\\Development\\CSE214\\HomeWork6\\src\\app\\Stopwords.txt").toString()
                    .split("\\r?\\n");

    public Passage(String title, File file) {
        this.title = title;
        parseFile(file);
    }

    public static double cosineSimilarity(Passage passage1, Passage passage2) {
        double top = 0;
        double bot1 = 0;
        double bot2 = 0;
        String words[] = ((passage1.wordCount > passage2.wordCount) ? passage1.getWords().toArray(new String[0])
                : passage2.getWords().toArray(new String[0]));

        passage1.getWords().toArray(new String[0]);

        for (int i = 0; i < words.length; i++) {
            top += passage1.getWordFrequency(words[i]) * passage2.getWordFrequency(words[i]);
            bot1 += (Math.pow((Double) (passage1.getWordFrequency(words[i])), 2));
            bot2 += (Math.pow((Double) (passage2.getWordFrequency(words[i])), 2));
        }
        passage1.similarTitles.put(passage2.getTitle(), 100 * (top / (Math.sqrt(bot1) * Math.sqrt(bot2))));
        passage2.similarTitles.put(passage1.getTitle(), 100 * (top / (Math.sqrt(bot1) * Math.sqrt(bot2))));
        return 100 * (top / (Math.sqrt(bot1) * Math.sqrt(bot2)));
    }

    public void parseFile(File file) {
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
        return similarTitles.toString();
    }
}
