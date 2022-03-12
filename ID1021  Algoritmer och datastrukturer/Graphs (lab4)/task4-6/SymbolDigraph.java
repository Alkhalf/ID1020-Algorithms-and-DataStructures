/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en Symbol directed Graph med String data type.
Konstructor SymbolDigraph tar in file namn och delimiter sedan läser in 
filen med hjälp av klassen In. 
Koden  SymbolDigraph som har använt är från princeton (ch: 4.5) SymbolDigraph.java
https://algs4.cs.princeton.edu/42digraph/SymbolDigraph.java.html
Koden skapade den 2021/10/10
Sista upptadering 2021/10/13
 */

package labb4task6;

import labb4task1.In;
import labb4task1.ST;

public class SymbolDigraph {
    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Digraph graph;           // the underlying digraph


    public SymbolDigraph(String filename, String delimiter) {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < 2; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        // inverted index to get string keys in an array
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the digraph by connecting first vertex on each
        // line to all others
        graph = new Digraph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i <2; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }

    //take a string and check if ST contains this string
    public boolean contains(String s) {
        return st.contains(s);
    }

    //take a string and check what have this for Value in ST
    public int indexOf(String s) {
        return st.get(s);
    }

    //take a Integer and check what have this for Key in ST
    public String nameOf(int v) {
        return keys[v];
    }

  //return Digraph
    public Digraph digraph() {
        return graph;
    }

}
