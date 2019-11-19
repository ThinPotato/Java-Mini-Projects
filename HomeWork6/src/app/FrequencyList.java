/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.util.ArrayList;
import java.util.Hashtable;

class FrequencyList {
    String word;
    ArrayList<Integer> frequencies;
    Hashtable<String, Integer> passageIndices;
    int i = 0;

    public FrequencyList(String word, Passage passage) {
        this.word = word;
        addPassage(passage);
    }

    public FrequencyList(String word, ArrayList<Passage> passages) {
        this.word = word;
        for (int k = 0; k < passages.size(); k++) {
            addPassage(passages.get(k));
        }
    }

    /**
     * @param p the passage to use
     */
    public void addPassage(Passage p) {
        passageIndices.put(p.getTitle(), i++);
        frequencies.add((int) p.getWordFrequency(word) * 100);
    }

    /**
     * @return the frequency of p
     * @param p the passage to look in
     */
    public int getFrequency(Passage p) {
        if (passageIndices.contains(word))
            return (int) (p.getWordFrequency(word) * 100);
        else
            return 0;

    }
}