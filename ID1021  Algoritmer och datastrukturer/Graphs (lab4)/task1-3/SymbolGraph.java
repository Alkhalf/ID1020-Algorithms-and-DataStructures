/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för en Symbol Graph med String data type.
Konstructor SymbolGraph tar in file namn och delimiter sedan läser in 
filen med hjälp av klassen In. 
Koden  SymbolGraph som har använt är från princeton (ch: 4.3) SymbolGraph.java
https://algs4.cs.princeton.edu/41graph/SymbolGraph.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */

package labb4task1;

public class SymbolGraph {
    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph graph;             // the underlying graph

    public SymbolGraph(String filename, String delimiter) {
    	//Skapa st av type String o Integer
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        //läsa in hela filen
        while (in.hasNextLine()) {
        	//spaara varje line i array a
            String[] a = in.readLine().split(delimiter);
            //Gå igenom arrayen om vertix finns inte i ST addera den 
    
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        // inverted index to get string keys in an array
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            //första index i ST är sourcen
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
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



   //return graph
    public Graph graph() {
        return graph;
    }
}
