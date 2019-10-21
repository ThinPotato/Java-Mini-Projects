package app;

import java.util.LinkedList;

/**
 * Queue
 */
public interface Queue {

    Queue<String> queue = new LinkedList<String>();

    public void enqueue(Bigram b);

    public Bigram dequeue();

    public Bigram peek();

    public int size();

    public boolean isEmpty();
}