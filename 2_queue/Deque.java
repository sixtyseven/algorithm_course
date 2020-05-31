import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        N++;
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = last = newNode;
        } else {
            Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            oldFirst.previous = first;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        N++;
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = last = newNode;
        } else {
            Node oldLast = last;
            last = newNode;
            last.previous = oldLast;
            oldLast.next = last;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        N--;
        Node oldFirst = first;
        Item item = oldFirst.item;
        first = oldFirst.next;
        oldFirst.next = null;
        if (first != null) {
            first.previous = null;
        } else {
            last = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        N--;
        Node oldLast = last;
        Item item = oldLast.item;
        last = oldLast.previous;
        oldLast.previous = null;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new NIterator();
    }

    private class NIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("Hi");
        deque.addFirst("hello");
        System.out.println(deque.size());
        deque.addLast("world");
        System.out.println(deque.size());
        for (String s : deque) {
            System.out.println(s);
        }
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());  // 1
        //
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        deque.addFirst("Hi2");
        deque.addFirst("hello2");
        deque.addLast("world2");
        System.out.println(deque.size());
        for (String s : deque) {
            System.out.println(s);
        }
    }
}
