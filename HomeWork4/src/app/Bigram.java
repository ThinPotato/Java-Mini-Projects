/**
 * Block
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

/**
 * Bigram
 */
public class Bigram {
    private char first;
    private char second;

    public Bigram() {

    }

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @return bigrams formatted as first letter Second Letter
     */
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

    /**
     * @param first the first to set
     */
    public void setFirst(char first) {
        this.first = first;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(char second) {
        this.second = second;
    }
}