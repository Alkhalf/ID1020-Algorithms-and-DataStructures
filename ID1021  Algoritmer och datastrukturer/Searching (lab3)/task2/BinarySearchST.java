/*@author Ahmed Alkhalaf
Task 2 i labb 3
Koden är imblementation för Symbol table med generellt type av  
Key och Value. Detta gjords genom att skapa en tom Symbol table
först sedan kopplar varje Value med en Key med hälp av  put() metod. 
main () metod läser string ord från filen "the_text.txt" och fylla på Symbol table.
Det innrhåller också Frequency counter som räknar den mest kommande ord som 
är större än viss length.
the_text.txt filen är den filtirade resultat som jag har fått från task1.
Koden BinarySearchST som har använt är från princeton (ch: 3.1)SequentialSearchST.java
och Frequency counter från Algorithmes Kurslitratur (sidan 372).
average case search lg(N)
average case insert 1/2( N)
Koden skapade den 2021/09/29 
Sista upptadering 2021/10/04
 */

package labb3task2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   

    // resize the underlying arrays
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
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
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (isEmpty()) return null;
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    } 

    /**
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 

        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
        	//medel element
            int mid = lo + (hi - lo) / 2; 
            //sätta 
            int cmp = key.compareTo(keys[mid]);
            //keys[mid] > key
            if      (cmp < 0) hi = mid - 1;
            //keys[mid] < key
            else if (cmp > 0) lo = mid + 1; 
            //keys[mid] = key
            else return mid; 
        } 
        return lo;
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
    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) resize(2*keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

    } 

    /**
     * Removes the specified key and associated value from this symbol table
     * (if the key is in the symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);

    } 

    
    /**
     * Return the kth smallest key in this symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in this symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    
public static void main(String []args) throws IOException {
    Stopwatch timer = new Stopwatch();
    int minlen =0;
	Scanner word = new Scanner(new File("the_text.txt"));
    BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();

    for (int i=0; i<1000; i++) {
        String str = word.next();

    	// Ignore short keys which have length sorter then minlen.
    	if (str.length() < minlen) 
    		continue; 
    	//put the word with first value
        if (!st.contains(str)) 
        	st.put(str, 1);
        //Get the last value for the word and put it after 
        else                    
        	st.put(str, st.get(str) + 1);

    	}
 // Find a key with the highest frequency count.
    String max = "";
    st.put(max, 0);

    for(int j=0; j<st.n; j++) {
    	String w= st.select(j);
       if (st.get(w) > st.get(max)) {
    	   max = w;
       }
    	}
    System.out.println( "The word is [" + max + "]," + st.get(max));
    double time = timer.elapsedTime();
    System.out.println("The runing time for Binary Search ST is "+ time + " Second");
	}
}
