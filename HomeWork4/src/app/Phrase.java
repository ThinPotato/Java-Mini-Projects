package app;

/**
 * Phrase
 */

class Phrase implements Queue<Bigram> {

    public Phrase() {

    }

    public static Phrase buildPhraseFromString(String s) {

    }

    public Phrase encrypt(KeyTable key) {

    }

    public Phrase decrypt(KeyTable key) {

    }

    public String toString() {

    }

    @Override
    public void enqueue(Bigram b) {
        // TODO Auto-generated method stub

    }

    @Override
    public Bigram dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bigram peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
}