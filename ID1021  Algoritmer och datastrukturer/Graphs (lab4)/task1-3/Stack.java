/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en LIFO Stack med generellt type av  
Item. Detta gjords genom att skapa en tom stack
först sedan adderar nya item i toppen av stack med hälp av  push() metod. 
Koden  Stack som har använt är från princeton (ch: 1.2) Stack.java
https://algs4.cs.princeton.edu/13stacks/Stack.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //intilaize an empty stack
    public Stack() {
        first = null;
        n = 0;
    }

    //return true if first is empty
    public boolean isEmpty() {
        return first == null;
    }

    //return size of stack
    public int size() {
        return n;
    }

    //add new item (node) on the top of stack
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
  
    //returns an iterator to this stack that iterates through the items in LIFO order.
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
