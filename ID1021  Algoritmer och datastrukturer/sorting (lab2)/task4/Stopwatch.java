/*@author Ahmed Alkhalaf
 * Task4 i labb 2
 * Denna kod är implementation för insertion Sort, Merge Sort och Quick Sort 
 * med tillägg som beräknar exekverings tid för varje algoritm för sig.
 * Alla algoritmer får samma array length med exakt samma elementer så att
 * jämföralse bli llika mellan de olika tre algoritmer
 * Algoritmer är kopierade från princeton Ch2.4 (Merge.java)och  Ch 2.5 (Quick.java) 
 * men absolut main metod gjorde på egenhand så att testa och undersöka de olika tre algoritmer.
 * Koden skapade den 2021/09/20
 * Sista upptadering 2021/09/25
 * 
 */


package task4;

import java.util.Random;
import java.util.Scanner;
public class Stopwatch {
	/*private final long start;
	public Stopwatch() {
        start = System.currentTimeMillis();
    } 
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }*/
    
    public static void main(String[] args) {
    	System.out.println("Enter the number of array");
		   int length = new Scanner(System.in).nextInt();
		   
		   
		   
		   String numbersArray[]=new String [length];
	       String numbersArray1[]=new String [length];
	       String numbersArray2[]=new String [length];
	       System.out.println("Enter the number of array");
	       for (int i=0; i< length; i++) {
	    	   String word = new Scanner(System.in).next();
	    	   numbersArray[i]= word;
	    	  // numbersArray1[i]=numbersArray[i];
	    	   //numbersArray2[i]=numbersArray[i];
	       }
	       Merge.sort(numbersArray);
	       Merge.show(numbersArray);
		   

    	
	     /*  System.out.println("How many numbers?");
    	   Random rand = new Random(); //instance for random class
		   int length = new Scanner(System.in).nextInt();
	       int numbersArray[]=new int [length];
	       int numbersArray1[]=new int [length];
	       int numbersArray2[]=new int [length];

	       for (int i=0; i< length; i++) {
	    	   numbersArray[i]= rand.nextInt(1000);
	    	   numbersArray1[i]=numbersArray[i];
	    	   numbersArray2[i]=numbersArray[i];
	       }
		   Stopwatch timer = new Stopwatch();
	       Merge.sort(numbersArray);
	       double time = timer.elapsedTime();
	       System.out.println("The execution time for MergeSort is "+ time + " Second");
	       

	       Stopwatch timer1 = new Stopwatch();
	       Quick.sort(numbersArray1);
	       double time1 = timer1.elapsedTime();
	       System.out.println("The execution time for QuickSort is "+ time1 + " Second");	     
	    
	       Stopwatch timer2 = new Stopwatch();
	       insertion.sort(numbersArray2);
	       double time2 = timer2.elapsedTime();
	       System.out.println("The execution time for InsertionSort is "+ time2 + " Second");
*/
}
}