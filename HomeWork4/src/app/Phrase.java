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
        int x1, x2, y1, y2;
        int size = PlayfairEncryptionEngine.phrase.size();
        for (int i = 0; i < size; i++) {

            current = PlayfairEncryptionEngine.phrase.pop();
            char first = current.getFirst();
            char second = current.getSecond();
            y1 = key.findCol(first);
            y2 = key.findCol(second);
            x1 = key.findRow(first);
            x2 = key.findRow(second);
            // first case they are both in the same row
            if (y1 == y2) {
                if (x1 == key.getKeyTable().length) {
                    newFirst = key.getKeyTable()[y1][0];
                } else {
                    newFirst = key.getKeyTable()[y1][x1 + 1];
                }
                if (x2 == key.getKeyTable().length) {
                    newSecond = key.getKeyTable()[y2][0];
                } else {
                    newSecond = key.getKeyTable()[y2][x2 + 1];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            } else if (x1 == x2) {
                if (y1 == key.getKeyTable().length) {
                    newFirst = key.getKeyTable()[0][x1];
                } else {
                    newFirst = key.getKeyTable()[y1 + 1][x1];
                }

                if (x2 == key.getKeyTable().length) {
                    newSecond = key.getKeyTable()[0][x2];
                } else {
                    newSecond = key.getKeyTable()[y2 + 1][x2];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            } else {
                if (y1 > y2) {
                    newSecond = key.getKeyTable()[y1 - (y1 - y2)][x1];
                    newFirst = key.getKeyTable()[y2 + (y1 - y2)][x2];
                } else {
                    newSecond = key.getKeyTable()[y1 + (y2 - y1)][x1];
                    newFirst = key.getKeyTable()[y2 - (y2 - y1)][x2];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            }

        }
        return newPhrase;
    }

    public Phrase decrypt(KeyTable key) {
        char newFirst;
        char newSecond;
        Phrase newPhrase = new Phrase();
        Bigram current;
        int x1, x2, y1, y2;
        int size = PlayfairEncryptionEngine.encrypted.size();
        for (int i = 0; i < size; i++) {

            current = PlayfairEncryptionEngine.encrypted.pop();
            char first = current.getFirst();
            char second = current.getSecond();
            y1 = key.findCol(first);
            y2 = key.findCol(second);
            x1 = key.findRow(first);
            x2 = key.findRow(second);
            // first case they are both in the same row
            if (y1 == y2) {
                if (x1 == key.getKeyTable().length) {
                    newFirst = key.getKeyTable()[y1][0];
                } else {
                    newFirst = key.getKeyTable()[y1][x1 - 1];
                }
                if (x2 == key.getKeyTable().length) {
                    newSecond = key.getKeyTable()[y2][0];
                } else {
                    newSecond = key.getKeyTable()[y2][x2 - 1];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            } else if (x1 == x2) {
                System.err.println("called 2");
                if (y1 == key.getKeyTable().length) {
                    newFirst = key.getKeyTable()[0][x1];
                } else {
                    newFirst = key.getKeyTable()[y1 - 1][x1];
                }

                if (x2 == key.getKeyTable().length) {
                    newSecond = key.getKeyTable()[0][x2];
                } else {
                    newSecond = key.getKeyTable()[y2 - 1][x2];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            } else {
                System.err.println("called 3");
                if (y1 > y2) {
                    newSecond = key.getKeyTable()[y1 - (y1 - y2)][x1];
                    newFirst = key.getKeyTable()[y2 + (y1 - y2)][x2];
                } else {
                    newSecond = key.getKeyTable()[y1 + (y2 - y1)][x1];
                    newFirst = key.getKeyTable()[y2 - (y2 - y1)][x2];
                }
                newPhrase.add(new Bigram(newFirst, newSecond));
            }

        }
        return newPhrase;
    }

    public String toString() {
        String temp = "";
        int size = this.size();
        Phrase tempPhrase = (Phrase) this.clone();
        for (int i = 0; i < size; i++) {
            Bigram current = tempPhrase.pop();
            temp += current.getFirst();
            temp += current.getSecond();
        }
        return temp;
    }

}