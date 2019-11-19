package app;

import java.util.ArrayList;
import java.util.Hashtable;

class FrequencyList {
    String word;
    ArrayList<Integer> frequencies;
    Hashtable<String, Integer> passageIndices;
    int i = 0;

    public void addPassage(Passage p) {
        passageIndices.put(p.getTitle(), i++);
        frequencies.add((int) p.getWordFrequency(word));
    }

    public int getFrequency(Passage p) {
        if (passageIndices.contains(word))
            return (int) p.getWordFrequency(word);
        else
            return 0;

    }
}