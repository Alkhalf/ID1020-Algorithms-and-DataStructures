/*@author Ahmed Alkhalaf
main klass innehåller main metod (test metod) för alla första tre task i labb 4.
Användare får välja vilken task vill test. data som används i denna test är
"the_database.txt" https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat
Först skapa en symbol graph och sedan enligt användare val utförs DepthFirstPaths 
eller BreadthFirstPaths. 
Note: Vissa koder som använt i denna labb är utvecklade med basen av princton kurslitteratur 
men utvecklade till att passar vår behöv för denna labb.
main metod är skriven helt på egenhand av mig.
Koden skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

import java.util.Scanner;

public class main {
	public static void main (String []args) {
		
		
		System.out.println("Skriv in task nummer (1,2 eller3 )");
		Scanner scanner = new Scanner(System.in);
		int task = scanner.nextInt();
		
		//skapa symbolgraph av texten
		SymbolGraph mySymbolGraph =new SymbolGraph("the_database.txt", " ");
		Graph myGraph =new Graph (mySymbolGraph.graph());
		
		System.out.println("Enter the start point");
		String Str =scanner.next();
		int s = mySymbolGraph.indexOf(Str);
		
		System.out.println("Enter the destenation");
		String Str1= scanner.next();
		int s1 =mySymbolGraph.indexOf(Str1);

		switch(task) {
		
		//task1
		case 1:
	    	
			
		//AL- NM
		//AL TN VA WV PA OH MI WI MN SD WY UT NV OR CA AZ NM 
		//create DFS to myGraph with start point s as source
		DepthFirstPaths myDFS1 = new DepthFirstPaths(myGraph ,s);
		System.out.println("The path between vertices [" + Str + "] and [" +Str1 + "] is:");
            if (myDFS1.hasPathTo(s1)) {
            	for (String v : myDFS1.pathTo(s1, mySymbolGraph)) {
            		if (!v.equals(Str1))
            		System.out.print(v+ " --> ");
            		else {System.out.print(v);}
            	}
        }
		break;
		
		//task2
		case 2:
		//AL NM
		//AL TN MO OK NM 
		BreadthFirstPaths myDFS = new BreadthFirstPaths(myGraph ,s);
		System.out.println("The path between vertices [" + Str + "] and [" +Str1 + "] is:");
            if (myDFS.hasPathTo(s1)) {
            	for (String v : myDFS.pathTo(s1, mySymbolGraph)) {
            		if (!v.equals(Str1))
            		System.out.print(v+ " --> ");
            		else {System.out.print(v);}
            	}
        }
        break;
		
        
        //task3
		case 3:
		if (Str.equals(Str1))
		{
			System.out.println("The start point is same destnation");
		}
		else {
		BreadthFirstPaths myBFS = new BreadthFirstPaths(myGraph ,s);
			//finns path mellan s och s1 samt det finns minst en station mellan
            if ( myBFS.hasPathTo(s1) && myBFS.distTo(s1) > 1 )
            	{
            	System.out.println("The path between point [" + Str + "] and the destantion [" +Str1 + "] is:");
            	for (String v : myBFS.pathTo(s1, mySymbolGraph)) {
            		if (!v.equals(Str1))
            		System.out.print(v+ " --> ");
            		else {System.out.print(v);}
            	}
            }
            else {
            	System.out.println("It's direct way between [" + Str + "] and the destantion [" +Str1 + "]");
            }

		}
		break;
 
		}
	}

}