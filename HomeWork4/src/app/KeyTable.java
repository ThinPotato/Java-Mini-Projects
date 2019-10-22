package app;

/**
 * KeyTable
 */
public class KeyTable {
    private char[][] key = new char[5][5];

    public KeyTable() {

    }

    /**
     * @return
     * @param phrase the phrase to be used
     */
    public static KeyTable buildFromString(String phrase) {
        int tempInt = 0;
        KeyTable keyTable = new KeyTable();
        phrase = phrase.replaceAll(" ", "");
        phrase = phrase.toUpperCase();
        char[] alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ".toCharArray();
        try {
            for (int i = 0; i < phrase.length(); i++) {
                for (int j = 0; j < phrase.length(); j++) {
                    if (phrase.charAt(i) == phrase.charAt(j) && i != j) {
                        phrase = phrase.replaceFirst("(?s)(.*)" + Character.toString(phrase.charAt(i)), "$1" + "");
                    }
                }
            }
            for (int i = 0; i < alphabet.length; i++) {
                if (!phrase.contains(Character.toString(alphabet[i]))) {
                    phrase += alphabet[i];
                }
            }

            for (int i = 0; i < keyTable.getKeyTable().length; i++) {
                for (int j = 0; j < keyTable.getKeyTable()[i].length; j++) {

                    keyTable.getKeyTable()[i][j] = phrase.charAt(tempInt);
                    tempInt++;
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("error: Illegal Argument Exception");
        }
        return keyTable;
    }

    /**
     * @return the 2d array keytable data
     */
    public char[][] getKeyTable() {
        return key;
    }

    /**
     * @return the row of c
     * @param c the character to search for
     */
    public int findRow(char c) {
        try {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[i].length; j++) {
                    if (key[i][j] == c) {
                        return j;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Illegal Argument Exception");
        }
        return -1;
    }

    /**
     * @return the column of c
     * @param c the character to search for
     */
    public int findCol(char c) {
        try {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[i].length; j++) {
                    if (key[i][j] == c) {
                        return i;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Illegal Argument Exception");
        }
        return -1;
    }

    /**
     * @return the bigrams as first second
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                temp += (key[i][j] + " ");
            }
            temp += "\n";
        }
        return temp;
    }

    /**
     * @param key the key to set
     */
    public void setKey(char[][] key) {
        this.key = key;
    }
}