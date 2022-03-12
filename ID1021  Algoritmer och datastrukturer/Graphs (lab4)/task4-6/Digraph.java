/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en directed Graph med integer data type.
Konstructor Digraph använder bag som hjälp klass för att bygga grafen.
Digraph kan bildas utifrån viss längd, eller Inpun av typen In (filen av type In)
eller utifårn en Digraph.
Koden  Digraph som har använt är från princeton (ch: 4.3) Digraph.java
https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
Koden skapade den 2021/10/10 
Sista upptadering 2021/10/13
 */
package labb4task6;

import java.util.NoSuchElementException;

import labb4task1.Bag;
import labb4task1.In;
import labb4task1.Stack;

public class Digraph {
    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
 
    //Create a graph with length V
    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
        	//skapa ny bag för varje vertix
            adj[v] = new Bag<Integer>();
        }
    }
    
    //create a digraph from input In  
    public Digraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be non-negative");
            // update indegrees
            indegree = new int[V];
            // update adjacency lists
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
            	//uppdate bags which is cinnected to adj
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                int c =in.readInt();
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }

    //create a directed graph by taking as input anthor digraåh
    public Digraph(Digraph G) {
        if (G == null) throw new IllegalArgumentException("argument is null");

        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");

        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
        
   
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
 
    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

 


}
