/*@author Ahmed Alkhalaf
DepthFirstDirectedPaths är en klass som utförs DFS för att hitta EN vägg 
från node s till node v. Denna vägg behöver inte vara kortaste väggen.
dfs () metod går igenom noder recrusiv.
Koden  DepthFirstDirectedPaths som har använt är
från princeton (ch: 4.4) DepthFirstDirectedPaths.java
https://algs4.cs.princeton.edu/42digraph/DepthFirstDirectedPaths.java.html
Koden skapade den 2021/10/10 
Sista upptadering 2021/10/13
 */
package labb4task6;

import labb4task1.Stack;

public class DepthFirstDirectedPaths {
    private boolean[] marked;  // marked[v] = true iff v is reachable from s
    private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
    private final int s;       // source vertex

    
    //DFS Set arrays length to graph vertcies number
    public DepthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        //call dfs 
        dfs(G, s);
    }
    
    //dfs digrphen with start vertix v
    private void dfs(Digraph G, int v) { 
    	//mark vertix v as visited
        marked[v] = true;
        //get all the elemnts in the bag which is connected to vertix v
        for (int w : G.adj(v)) {
            if (!marked[w]) {
            	//set a connection bet w and v
                edgeTo[w] = v;
                //do same for w 
                dfs(G, w);
            }
        }
    }
    
    //return true if v have is marked as visited from sourcen
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    //return stack as String Iterable from  source to vertix which have index v
    public Iterable<String> pathTo(int v, SymbolDigraph Digraph) {
        if (!hasPathTo(v)) return null;
        //creat a stack with data type String
        Stack<String> path = new Stack<String>();
        //Start from v and gå back to the vertix befor until get sourcen 
        //and push those to stack so sourcen become on the top of the stack
        for (int x = v; x != s; x = edgeTo[x])
            path.push(Digraph.nameOf(x));
        path.push(Digraph.nameOf(s));
        return path;
    }
}