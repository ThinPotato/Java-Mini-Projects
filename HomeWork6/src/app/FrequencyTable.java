package app;

import java.util.ArrayList;

class FrequencyTable {

    ArrayList<FrequencyList> fl = new ArrayList<FrequencyList>();

    public static FrequencyTable buildTable(ArrayList<Passage> passages) {
        // TODO: implement method
        FrequencyTable ft = new FrequencyTable();
        for (int i = 0; i < passages.size(); i++) {
            String temp[] = passages.get(i).getWords().toArray(new String[0]);
            for (int k = 0; k < passages.get(i).getWordCount(); k++) {
                ft.fl.add(new FrequencyList(temp[k], passages));
            }
        }
        return ft;
    }

    public void addPassage(Passage p) throws IllegalArgumentException {
        // TODO implement method

    }

    public int getFrequency(String word, Passage p) {
        // TODO: implement method
        for (int i = 0; i < fl.size(); i++) {
            if (fl.get(i).word.equals(word)) {
                return fl.get(i).getFrequency(p);
            }
        }
        return -1;
    }
}