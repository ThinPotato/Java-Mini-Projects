package app;

/**
 * KeyTable
 */
public class KeyTable {
    private char[][] key = new char[5][5];

    public KeyTable() {

    }

    public static KeyTable buildFromString(String phrase) {
        int tempInt = 0;
        KeyTable keyTable = new KeyTable();
        phrase = phrase.replaceAll(" ", "");
        phrase = phrase.toUpperCase();
        char[] alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ".toCharArray();
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
        return keyTable;
    }

    public char[][] getKeyTable() {
        return key;
    }

    public int findRow(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == c) {
                    return j;
                }
            }
        }
        return -1;
    }

    public int findCol(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == c) {
                    return i;
                }
            }
        }
        return -1;
    }

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