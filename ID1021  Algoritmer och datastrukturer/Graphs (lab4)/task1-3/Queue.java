/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en FIFO Queue med generellt type av  
Item. Detta gjords genom att skapa en tom qeueu
först sedan adderar nya item i slutet av queue med hälp av  enqueue() metod. 
metoden dequeue retunerar den första element  i queue samt tar bort den från queue.
Koden  Queue som har använt är från princeton (ch: 1.3) Queue.java
https://algs4.cs.princeton.edu/13stacks/Queue.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    //return true if first is null
    public boolean isEmpty() {
        return first == null;
    }

  //return number of elements in the Q
    public int size() {
        return n;
    }


    //add item at the last in the Q
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    //retun the first (most old) elements in the Q and dlt it fromQ
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
    //Returns an iterator that iterates over the items in this queue in FIFO order.
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}
