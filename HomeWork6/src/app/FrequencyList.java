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

    public void addPassage(Passage p) {
        passageIndices.put(p.getTitle(), i++);
        frequencies.add((int) p.getWordFrequency(word) * 100);
    }

    public int getFrequency(Passage p) {
        if (passageIndices.contains(word))
            return (int) (p.getWordFrequency(word) * 100);
        else
            return 0;

    }
}