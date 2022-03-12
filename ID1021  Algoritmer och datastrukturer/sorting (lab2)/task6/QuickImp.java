/*@author Ahmed Alkhalaf
 * Task 6 i labb 2
 * Denna kod är implementation för Quick sort algoritm med Median of 3
 * för att förbättra Quick sort algoritm.  
 * Med tillägg som beräknar exekverings tid för denna algoritm.
 * Algoritmen är kopierade från princeton Ch2.5 (Quick.java) med extra metod median();
 * som skrev på egenhand med inspiration av förläsning 7 Slide 20,
 * main metod gjorde på egenhand så att testa och undersöka exekverings tid
 * för  de olika cut off elementer.
 * Koden skapade den 2021/09/22
 * Sista upptadering 2021/09/25
 * 
 */

package task6;
import java.util.Random;
import java.util.Scanner;

import task4.Quick;
import task5.Stopwatch;

public class QuickImp {

		public static void sort(int[] a) {
	        //StdRandom.shuffle(a);
	        sort(a, 0, a.length - 1);
	    }

	    // quicksort the subarray from a[lo] to a[hi]
	    private static void sort(int[] a, int lo, int hi) { 
	        if (hi <= lo) return;
	        //set pivot som i en index innan sista index
	       int median= median(a, lo, lo + (hi -lo)/2, hi);
	       //gör partition för elementer som är innan median 
	        int j = partition(a, lo,median);
	        
	        sort(a, lo, j-1);
	        sort(a, j+1, hi);
	    }
	    //välja median och sortera first, median och last enligt sina positioner
	    private static int median(int []a, int lo, int median, int hi) {
	    	//sortera de elementer
	    	while(a[hi]< a[lo] || a[median]< a[lo] || a[median] > a[hi]) {
	    	if (a[hi]< a[lo])
	    		exch(a,hi, lo);
	    	else if(a[median] < a[lo])
	    		exch(a,median,lo);
	    	else if (a[median] > a[hi])
	    		exch(a,median,hi);
	    	}
	    	//byta 
	    	exch(a, median, hi-1);
	    	return hi-1;
	    }
	    private static int partition(int[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi +1;
	        int v = a[lo];
	        while (true) { 

	            // find item on lo to swap
	            while ((a[++i] < v)) {
	                if (i == hi) break;
	            }

	            // find item on hi to swap
	            while ((v< a[--j])) {
	                if (j == lo) break;      // redundant since a[lo] acts as sentinel
	            }

	            // check if pointers cross
	            if (i >= j) break;

	            exch(a, i, j);
	        }

	        // put partitioning item v at a[j]
	        exch(a, lo, j);

	        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	        return j;
	    }
	 
	        
	    // exchange a[i] and a[j]
	    private static void exch(int[] a, int i, int j) {
	        int swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;

	    }
	    // print array to standard output
	    private static void show(int[] a) {
	        for (int i = 0; i < a.length; i++) {
	           System.out.print("[" + a[i]+"]");
	        
	    }
	    
	    
	 
	 }
	    public static void main(String []args) {
	    	/*   
	    	System.out.println("How many numbers?");
	    	Scanner scanner = new Scanner(System.in);
			int length = scanner.nextInt();
	    	int []arr= new int [length];
	    	System.out.println("Enter The numbers");
			   for (int i=0; i<length; i++) {
				   arr[i]=scanner.nextInt();
			   }
			   show(arr);

			   System.out.println();
			   sort(arr);
			   show(arr);
			   
			     */
			   System.out.println("How many numbers?");
	    	   Random rand = new Random(); //instance for random class
			   int length = new Scanner(System.in).nextInt();
		    	int []arr= new int [length];
		    	int []arr1= new int [length];

			   for (int i=0; i<length; i++) {
				   arr[i]= rand.nextInt(1000);
				   arr1[i]=  arr[i];
				   
			   }

			  
			 
			   Stopwatch timer = new Stopwatch();
		       sort (arr);
			   double time = timer.elapsedTime();
		       System.out.println("The execution time for improvment is "+ time + " Second");
		       
		       Stopwatch timer1 = new Stopwatch();
		       Quick.sort(arr1);
		       double time1 = timer.elapsedTime();
		       System.out.println("The execution time for QuickSort is "+ time1 + " Second"); 
		      
	    }

}
