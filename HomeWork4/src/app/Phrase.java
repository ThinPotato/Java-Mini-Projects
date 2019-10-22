/**
 * Block
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Phrase
 */

class Phrase extends LinkedList<Bigram> implements Queue<Bigram> {

    public Phrase() {

    }

    /**
     * @return the phrase built from the string
     * @param s the string to build the phrase from
     */
    public static Phrase buildPhraseFromStringForEncryption(String s) {
        Phrase temp = new Phrase();
        s = s.replaceAll(" ", "");
        s = s.toUpperCase();
        s = s.replaceAll("J", "I");
        for (int i = 0; i < s.length() - 1; i += 2) {
            String c1 = s.substring(i, i + 1);
            String c2 = s.substring(i + 1, i + 2);
            if (s.substring(i, i + 1).equals(s.substring(i + 1, i + 2)) && (i) % 2 == 0) {
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

    /**
     * @return the encrypted phrase
     * @param key the keytable to be used
     */
    public Phrase encrypt(KeyTable key) {
        char newFirst;
        char newSecond;
        Phrase newPhrase = new Phrase();
        Bigram current;
        int x1, x2, y1, y2;
        int size = PlayfairEncryptionEngine.phrase.size();
        try {
            for (int i = 0; i < size; i++) {

                current = PlayfairEncryptionEngine.phrase.pop();
                char first = current.getFirst();
                char second = current.getSecond();
                x1 = key.findCol(first);
                x2 = key.findCol(second);
                y1 = key.findRow(first);
                y2 = key.findRow(second);
                // first case they are both in the same row
                if (y1 == y2) {
                    if (x1 == key.getKeyTable().length - 1) {
                        newFirst = key.getKeyTable()[y1][0];
                    } else {
                        newFirst = key.getKeyTable()[y1][x1 + 1];
                    }
                    if (x2 == key.getKeyTable().length - 1) {
                        newSecond = key.getKeyTable()[y2][0];
                    } else {
                        newSecond = key.getKeyTable()[y2][x2 + 1];
                    }
                    newPhrase.add(new Bigram(newFirst, newSecond));
                } else if (x1 == x2) {
                    if (y1 == key.getKeyTable().length - 1) {
                        newFirst = key.getKeyTable()[0][x1];
                    } else {
                        newFirst = key.getKeyTable()[y1 + 1][x1];
                    }

                    if (x2 == key.getKeyTable().length - 1) {
                        newSecond = key.getKeyTable()[0][x2];
                    } else {
                        newSecond = key.getKeyTable()[y2 + 1][x2];
                    }
                    newPhrase.add(new Bigram(newFirst, newSecond));
                } else {
                    if (y1 < y2) {
                        newSecond = key.getKeyTable()[y1 - (y1 - y2)][x1];
                        newFirst = key.getKeyTable()[y2 + (y1 - y2)][x2];
                    } else {
                        newSecond = key.getKeyTable()[y1 + (y2 - y1)][x1];
                        newFirst = key.getKeyTable()[y2 - (y2 - y1)][x2];
                    }
                    newPhrase.add(new Bigram(newFirst, newSecond));
                }

            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Illegal Argument Exception");
        }
        return newPhrase;
    }

    /**
     * @return the decypted phrase
     * @param key the keytable to be used
     */
    public Phrase decrypt(KeyTable key) {
        char newFirst;
        char newSecond;
        Phrase newPhrase = new Phrase();
        Bigram current;
        int x1, x2, y1, y2;
        int size = PlayfairEncryptionEngine.encrypted.size();
        try {
            for (int i = 0; i < size; i++) {

                current = PlayfairEncryptionEngine.encrypted.pop();
                char first = current.getFirst();
                char second = current.getSecond();
                x1 = key.findCol(first);
                x2 = key.findCol(second);
                y1 = key.findRow(first);
                y2 = key.findRow(second);
                // first case they are both in the same row
                if (y1 == y2) {
                    if (x1 == 0) {
                        newFirst = key.getKeyTable()[y1][key.getKeyTable().length - 1];
                    } else {
                        newFirst = key.getKeyTable()[y1][x1 - 1];
                    }
                    if (x2 == 0) {
                        newSecond = key.getKeyTable()[y2][key.getKeyTable().length - 1];
                    } else {
                        newSecond = key.getKeyTable()[y2][x2 - 1];
                    }
                    newPhrase.add(new Bigram(newFirst, newSecond));
                } else if (x1 == x2) {
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
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Illegal Argument Exception");
        }
        return newPhrase;
    }

    /**
     * @return the phrase converted to a string
     */
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