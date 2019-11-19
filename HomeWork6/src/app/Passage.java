package app;

import java.util.Hashtable;
import java.util.Set;

class Passage {
    String title;
    int wordCount;
    Hashtable<String, Double> similarTitles = new Hashtable<String, Double>();

    public void parseFile(File file) {
        // TODO: implement method
    }

    public double getWordFrequency(String word) {
        // TODO: implement method
    }

    public Set<String> getWords() {
        // TODO: implement method
    }

    public String getTitle() {
        // TODO: implement method
    }

    public int getWordCount() {
        // TODO: implement method
    }

    public void setWordCount(int owrdCount) {
        // TODO: implement method
    }

    public Hashtable<String, Double> getSimilarTitles() {
        // TODO: implement method
    }

    public void setSimilarTitles(Hashtable<String, Double> similarTitles) {
        // TODO: implement method
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
