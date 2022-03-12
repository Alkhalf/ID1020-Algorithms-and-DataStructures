/*@author Ahmed Alkhalaf
Task 6 i labb 3
Koden är imblementation för Binary Search Tree med generellt type av  
Key och Value. Detta gjords genom att skapa en tom Symbol table
först sedan kopplar varje Value med en Key med hälp av  put() metod
genom att hämta index där det ska hasha och sedan med hjlälp av
SequentialSearchST sätter den i en node med avseende på Value för den.
main () metod läser string ord från filen "the_text.txt" och fylla på Symbol table.
sedan upprepar fråga om använder vill kontrollera något annat ord utan att läsa 
från filen igen eller bilda om hash tabel.
the_text.txt filen är den filtirade resultat som jag har fått från task1.
Koden  SeparateChainingHashST som har använt är från princeton (ch: 3.5) 
SeparateChainingHashST.java och SequentialSearchST.java (ch: 3.1)
main () metod är helt på egenhand. 
Koden skapade den 2021/10/01 
Sista upptadering 2021/10/04
 */
package labb3task6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables


    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    } 

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m-1);
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public  int size() {
        return n;
    } 
   

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);
        //get the index for the key
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 
    
  
public static void main(String []args) throws FileNotFoundException   {
    Scanner word = new Scanner(new File("the_text.txt"));
 	SeparateChainingHashST <String, Integer> st1 = new SeparateChainingHashST<String, Integer>();
    int minlen=0;
    while (word.hasNext()) {
    	String str=word.next();
    	
      	// Ignore short keys which have length sorter then minlen.
      	if (str.length() < minlen) 
      		continue; 
      	//put the word with first value
          if (!st1.contains(str)) 
          	st1.put(str, 1);
          //Get the last value for the word and put it after 
          else                    
          	st1.put(str, st1.get(str) + 1);
	}
    
    	System.out.println("Enter 1 if you want to start");
		int swit = new Scanner(System.in).nextInt(); 
		//repetera kontrollen 
		while (swit==1){
	    	System.out.println("Enter the word to check:");
	    	String key =new Scanner(System.in).next();
	    	//kontrollera om key finns i listan
	    	if (st1.contains(key)) {
	    		//får value för key
	    		int valu= st1.get(key);
	    		System.out.println("The word ["+ key +"] found in the text "+ valu +" time");
	    		System.out.println("Enter 1 if you want to continu");
	    		swit=new Scanner(System.in).nextInt(); 
	    		}
        else {
        		System.out.println ("The ["+ key + "] is not in the text");
        		System.out.println("Enter 1 if you want to continu");
        		swit=new Scanner(System.in).nextInt(); 
			}
	
		}
		System.out.println("Done!");
}
    

}
