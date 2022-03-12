/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en undirected Graph med integer data type.
Konstructor Graph använder bag som hjälp klass för att bygga grafen.
Grafen kan bildas utifrån viss längd eller utifårn en graf.
Koden  Graph som har använt är från princeton (ch: 4) Graph.java
https://algs4.cs.princeton.edu/41graph/Graph.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */

package labb4task1;

public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
   //Create a graph with length V
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        // update adjacency lists 
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
        	//skapa ny bag för varje vertix
            adj[v] = new Bag<Integer>();
        }
    }

 

    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");

        // update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
        	//skapa ny bag för varje vertix
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
        E++;
        //add w till bag som är kopplade till adj[v]
        adj[v].add(w);
        adj[w].add(v);
    }


    public Iterable<Integer> adj(int v) {
        return adj[v];
    }



}