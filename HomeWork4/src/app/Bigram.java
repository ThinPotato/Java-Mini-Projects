package app;

/**
 * Bigram
 */
public class Bigram {
    private char first;
    private char second;

    public Bigram() {

    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    /**
     * @return the first
     */
    public char getFirst() {
        return first;
    }

    /**
     * @return the second
     */
    public char getSecond() {
        return second;
    }
}