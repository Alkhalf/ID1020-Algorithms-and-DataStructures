/*@author Ahmed Alkhalaf
main klass innehåller main metod (test metod) för task 4 och task 6 i labb 4.
Användare får välja vilken task vill test. Data som används i denna test är
"the_database.txt" https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat
och "NYC.txt" https://algs4.cs.princeton.edu/44sp/NYC.txt.
Enligt användare val utförs DepthFirstDirectedPaths eller BreadthFirstDirectedPaths. 
Note: Vissa koder som använt i denna labb är utvecklade med basen av princton kurslitteratur 
men utvecklade till att passar vår behöv för denna labb.
main metod är skriven helt på egenhand av mig.
Koden skapade den 2021/10/10 
Sista upptadering 2021/10/13
 */
package labb4task6;

import java.util.Scanner;

import labb4task1.In;

public class main {
	public static void main (String []args) {
		
		System.out.println("Skriv in task nummer ( 4 eller 6 )");
		Scanner scanner = new Scanner(System.in);
		int task = scanner.nextInt();
		switch(task) {
		
		case 4:
			//AL OK
			//AL VA
	SymbolDigraph mySymbolGraph =new SymbolDigraph("the_database.txt", " ");
	Digraph myDigrph = new Digraph (mySymbolGraph.digraph());
	System.out.println("Enter the start vertice");
	
	//Scanner scanner = new Scanner(System.in);
	String Str =scanner.next();
	int s = mySymbolGraph.indexOf(Str);
	System.out.println("Enter the End vertice");
	String Str1= scanner.next();
	int s1 =mySymbolGraph.indexOf(Str1);
	DepthFirstDirectedPaths myDFDP = new DepthFirstDirectedPaths(myDigrph, s);
        if (myDFDP.hasPathTo(s1)) {
        	for (String r : myDFDP.pathTo(s1, mySymbolGraph)) {
        		if (!r.equals(Str1)) 
        		System.out.print(r+ " --> ");

        		else {
        			System.out.print(r);
        			}
        	}

        	
        }
        else {
        	System.out.println("There is no directed way between ["+ Str +"] and [" + Str1+"]");
        }

    break;
	
		
		
		case 6:
		//2- 1355 via 1
		//2->1->1363->1358->1355
		In myFile = new In ("NYC.txt");
		Digraph myDigrph6 = new Digraph (myFile);
		
		
		
		System.out.println("Enter the start point");
		int Strr =scanner.nextInt();
		
		System.out.println("Enter the destnation");
		int Strr1= scanner.nextInt();

		System.out.println("Enter the point that you want passing through it");
		int Strr2 =scanner.nextInt();

		BreadthFirstDirectedPaths myBFDP = new BreadthFirstDirectedPaths(myDigrph6, Strr);
		BreadthFirstDirectedPaths myBFDP2 = new BreadthFirstDirectedPaths(myDigrph6, Strr2);

	
		            if (myBFDP.hasPathTo(Strr2) && myBFDP2.hasPathTo(Strr1)) {
		                for (int x : myBFDP.pathTo(Strr2) ) {
		                    if (x == Strr)  System.out.print(x);
		                    else         System.out.print("->" + x);
		                }
		                for (int x1 : myBFDP2.pathTo(Strr1) ) {
		                    if (x1 != Strr2) 
		                      System.out.print("->" + x1);
		                }
		            }
          }
	}
}
