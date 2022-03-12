/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en Symbol Table med generellt type av  
Key och Value. Detta gjords genom att skapa en tom stack
först sedan adderar nya Key i första noden av ST eller om Key finns redan
i ST då uppdatera sitt Value (index) bara med hälp av  put() metod. 
Koden  ST som har använt är från princeton (ch: 3.1) BinarySearchST.java
men det är ingen "sökning" som utförs i denna klass utan det bara en form 
av ST.
https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

public class ST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

   //return number of key-value pairs
    public int size() {
        return n;
    }
 
    //return true if key is in ST
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    //return Value which is pair to key
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        //go thr all the nodes in ST 
        for (Node x = first; x != null; x = x.next) {
        	//check if its equals key
            if (key.equals(x.key)) {
            	return x.val;
            }
                
        }
        return null;
    }
 
    // add new key and value in ST
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 
        if (val == null) {
            return;
        }
        //go thr all the nodes in ST
        for (Node x = first; x != null; x = x.next) {
        	//uppdate the value
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        //if Key was new key; creat new node and put it as first
        first = new Node(key, val, first);
        n++;
    }

    //Returns all keys in this symbol table in the given range, as Iterable Q
    public Iterable<Key> keys()  {
    	Queue <Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return (Iterable<Key>) queue;
    }


}
