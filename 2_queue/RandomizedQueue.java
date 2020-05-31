import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;
    private int N = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (N == s.length) {
            resize(2 * N);
        }

        s[N++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double rand = Math.random() * N;
        int randIdx = (int) Math.floor(rand);
        Item item = s[randIdx];
        N--;
        s[randIdx] = s[N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double rand = Math.random() * N;
        int idx = (int) Math.floor(rand);
        Item item = s[idx];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new AIterator();
    }

    private class AIterator implements Iterator<Item> {
        private int i = N;
        private Item[] copy = (Item[]) new Object[N];

        public AIterator() {
            for (int i = 0; i < N; i++) {
                copy[i] = s[i];
            }
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (i == 0) {
                throw new NoSuchElementException();
            }

            int randomIdx = (int) Math.floor(Math.random() * i);
            i--;
            Item tmpItem = copy[i];
            copy[i] = copy[randomIdx];
            copy[randomIdx] = tmpItem;

            Item returnItem = copy[i];
            copy[i] = null;
            return returnItem;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(11);
        randomizedQueue.enqueue(22);
        randomizedQueue.enqueue(33);
        randomizedQueue.enqueue(44);
        randomizedQueue.enqueue(55);
        System.out.println(randomizedQueue.size());
        Iterator<Integer> i = randomizedQueue.iterator();
        Iterator<Integer> j = randomizedQueue.iterator();

        while(i.hasNext()) {
            int val1 = i.next();
            int val2 = j.next();
            StdOut.println(val1);
            StdOut.println(val2);
            StdOut.println("");
        }




    }

}