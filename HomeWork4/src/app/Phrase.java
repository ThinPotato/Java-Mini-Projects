package app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Phrase
 */

class Phrase extends LinkedList<Bigram> implements Queue<Bigram> {

    public Phrase() {

    }

    public static Phrase buildPhraseFromString(String s) {
        Phrase temp = new Phrase();
        s = s.replaceAll(" ", "");
        s = s.toUpperCase();
        s = s.replaceAll("J", "I");
        for (int i = 0 + 1; i < s.length() - 2; i++) {
            if (s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
                s = s.substring(0, i + 1) + "X" + s.substring(i + 1, s.length());
            }
        }
        String[] sArray = (s.split("(?<=\\G..)"));
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].length() == 1) {
                sArray[i] = sArray[i].substring(0, 1) + "X";

            }
            temp.add(new Bigram(sArray[i].charAt(0), sArray[i].charAt(1)));
        }
        return temp;
    }

    public Phrase encrypt(KeyTable key) {
        char newFirst;
        char newSecond;
        Phrase newPhrase = new Phrase();
        Bigram current;
        for (int i = 0; i < PlayfairEncryptionEngine.phrase.size(); i++) {
            current = PlayfairEncryptionEngine.phrase.pop();
            char first = current.getFirst();
            char second = current.getSecond();
            System.out.println(key.findRow(first));
            if (key.findRow(first) == key.findRow(second)) {
                if (key.findCol(first) == key.getKeyTable().length) {
                    newFirst = key.getKeyTable()[key.findRow(first)][0];
                } else {
                    newFirst = key.getKeyTable()[key.findRow(first)][key.findCol(first) + 1];
                }
                if (key.findCol(second) == key.getKeyTable().length) {
                    newSecond = key.getKeyTable()[key.findRow(first)][0];
                } else {
                    newSecond = key.getKeyTable()[key.findRow(first)][key.findCol(second) + 1];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            }

        }
        return newPhrase;
    }

    public Phrase decrypt(KeyTable key) {

    }

    public String toString() {

    }

}