/*@author Ahmed Alkhalaf
BreadthFirstDirectedPaths är en klass som utförs BFS för att hitta kortasete väggen 
från node s till node v.
bfs () metod använder Qeueu för att spara noder som ska gå igenom.
Koden  BreadthFirstDirectedPaths som har använt är 
från princeton (ch: 4.4) BreadthFirstDirectedPaths.java
https://algs4.cs.princeton.edu/42digraph/BreadthFirstDirectedPaths.java.html
Koden skapade den 2021/10/10 
Sista upptadering 2021/10/13
 */
package labb4task6;

import labb4task1.Queue;
import labb4task1.Stack;

public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path


    //Set length to the arrays 
    public BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        //set length of all vertices to infinity
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        bfs(G, s);
    }


    // BFS from single source
   //comput the shortest way between sourcen (s) and all other vertices in the graph 

    private void bfs(Digraph G, int s) {
    	//create an Qeueue av type Integer
        Queue<Integer> q = new Queue<Integer>();
        //Set soucen to dst 0 och mark it as visitid
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        
        while (!q.isEmpty()) {
        	//get first value in the Q
            int v = q.dequeue();
            //get the vertices (elements) in the bag which is coneccted with
            // the vertix v
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                	//make connection bet w and v
                    edgeTo[w] = v;
                    //get the dst bet w and v
                    distTo[w] = distTo[v] + 1;
                    //mark w as visited
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    
    //return true if v marked as visited from the source s
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // return dst from s to v
    public int distTo(int v) {
        return distTo[v];
    }
    
    //return stack as Intger Iterable from  source to vertix which have index v
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        //creat a stack with data type Integer
        Stack<Integer> path = new Stack<Integer>();
        int x;
        //Start from v and gå back to the vertix befor until get sourcen 
        //and push those to stack so sourcen become on the top of the stack
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

   
}