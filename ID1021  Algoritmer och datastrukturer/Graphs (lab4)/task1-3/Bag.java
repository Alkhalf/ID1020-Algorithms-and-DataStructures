/*@author Ahmed Alkhalaf
en hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en multiset bag med generellt type av  
Item. Detta gjords genom att skapa en tom bag
först sedan adderar nya item i bag bak ifrån med hälp av  add() metod. 
och sedan retunerar iterable item i bagen utan hänsyn till ordning.
Koden Bag som har använt är från princeton (ch: 1.4) Bag.java
https://algs4.cs.princeton.edu/13stacks/Bag.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */

package labb4task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    //Initializes an empty bag.
    public Bag() {
        first = null;
        n = 0;
    }

   //retunera number of elements in the bag
    public int size() {
        return n;
    }

   //add new elements to the bag by adding them from back
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    //retunera elementer in the bag with out order
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

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