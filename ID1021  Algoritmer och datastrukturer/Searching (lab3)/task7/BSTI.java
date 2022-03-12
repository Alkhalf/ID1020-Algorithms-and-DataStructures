/*@author Ahmed Alkhalaf
Task 7 i labb 3
Koden är imblementation för Binary Search Tree med generellt type av  
Key och Value. Detta gjords genom att skapa en tom Symbol table
först sedan kopplar varje Value med en Key med hälp av  put() metod. 
När det koppla en Value med en  Key som finns redan i ST då bytas den 
gamla Value med den nya Value
main () metod läser string ord från filen "the_text.txt" och fylla på Symbol table.
Det innrhåller också print () och printRev() metoder som i sitt tur skriva ut all 
key som finns i BST.
the_text.txt filen är den filtirade resultat som jag har fått från task1.
Koden  Binary Search Tree som har använt är från princeton (ch: 3.2) BST.java
Koden skapade den 2021/09/30 
Sista upptadering 2021/10/04
 */
package labb3task7;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BSTI<Key extends Comparable<Key>, Value> {
    private  Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BSTI() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
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
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
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
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
   
    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 


    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    }
    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if      (leftSize > rank) return select(x.left,  rank);
        else if (leftSize < rank) return select(x.right, rank - leftSize - 1); 
        else                      return x.key;
    }
    
    /* Recursive traversal för att skriva ut alla nycklar som finns på 
     * vänster av rooten recursive som är vilken är mindre än nycklen som 
     * finns i root sedan recrusive skriva ut alla vucklar som finns på 
     * höger av root och är större än nycklen som finns i root.
     */
    private void print(Node x) {
    	   if (x == null) return;
    	   print(x.left);
    	   System.out.println("[" + x.key +"]");
    	   print(x.right);

    	}
    
    //samma princip som använt i ordning print() metod men tvärtom ordning på utskrivt.
    private void printRev(Node x) {
 	   if (x == null) return;
 	   printRev(x.right);
 	   System.out.println("[" + x.key + "]");
 	   printRev(x.left);

 	}
 
    public static void main(String []args) throws IOException {
          int minlen =0;
      	  Scanner word = new Scanner(new File("the_text.txt"));
      	  //skapa objekt
          BSTI<String, Integer> st1 = new BSTI<String, Integer>();
         
          for (int i=0; i< 200; i++) {
        	  //Läsa från filen samt konvert till små bokstäver
              String s = word.next().toLowerCase();
          	// Ignore short keys which have length sorter then minlen.
          	if (s.length() < minlen) 
          		continue; 
        	//put the word with first value
              if (!st1.contains(s)) 
              	st1.put(s, 1);
              //Get the last value for the word and put it after 
              else                    
              	st1.put(s, st1.get(s) + 1);
                          	 
          }
        System.out.println("Press 1 if you want print the words in alphabetical order.");
        System.out.println("Press 2 if you want print the words in inreverse alphabetic order");
        System.out.println("press any Integer number to Exit ");
        Scanner scanner = new Scanner(System.in);
  		int swit = scanner.nextInt(); 
          switch(swit) {
          case 1:
        	  st1.print(st1.root);
          	break;
          
          case 2:
          	  
              st1.printRev(st1.root);
            break;
            
        /*  case 3:
        	  String check = new Scanner(System.in).next();
        	  boolean checked= st1.contains(check);
        	  System.out.println(checked);
        	  break;*/

          }
         
    }
}