/*@author Ahmed Alkhalaf
DepthFirstPaths är en klass som utförs DFS för att hitta EN vägg 
från node s till node v. Denna vägg behöver inte vara kortaste väggen.
dfs () metod går igenom noder recrusiv.
Koden  DepthFirstPaths som har använt är från princeton (ch: 4.1) DepthFirstPaths.java
https://algs4.cs.princeton.edu/41graph/DepthFirstPaths.java.html
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        //set edgeTo and marked length
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // depth first search from v
    // and go in all ways wich is conected to the source v
    private void dfs(Graph G, int v) {
        marked[v] = true;
        //get the vertices (elements) in the bag which is coneccted with
        // the vertix v
        for (int w : G.adj(v)) {
            if (!marked[w]) {
            	//make connection bet w and v
                edgeTo[w] = v;
                //recrusiv do same with w
                dfs(G, w);
            }
        }
    }

    //return true if v marked as visited from the source s
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    //return stack as String Iterable from  source to vertix which have index v
    public Iterable<String> pathTo(int v, SymbolGraph Graph) {
        if (!hasPathTo(v)) return null;
        //creat a stack with data type String
        Stack<String> path = new Stack<String>();
        //Start from v and gå back to the vertix befor until get sourcen 
        //and push those to stack so sourcen become on the top of the stack
        for (int x = v; x != s; x = edgeTo[x])
            path.push(Graph.nameOf(x));
        path.push(Graph.nameOf(s));
        return path;
    }
}