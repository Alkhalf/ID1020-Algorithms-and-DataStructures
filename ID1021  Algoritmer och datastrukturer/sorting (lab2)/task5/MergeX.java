/*@author Ahmed Alkhalaf
 * Task 5 i labb 2
 * Denna kod är implementation för  Merge Sort med cut off element
 * med tillägg som beräknar exekverings tid för denna algoritm.
 * Algoritmen är kopierade från princeton Ch2.4 (MergeX.java)
 * men absolut main metod gjorde på egenhand så att testa och undersöka exekverings tid
 * för  de olika cut off elementer.
 * Koden skapade den 2021/09/21
 * Sista upptadering 2021/09/25
 * 
 */


package task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import task4.Merge;

public class MergeX {
    private static final int CUTOFF = 30;
    private static void merge(int [] src, int[] dst, int lo, int mid, int hi) {

        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if ((src[j]< src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }
    }
        private static void sort(int[] src, int[] dst, int lo, int hi) {
            // if (hi <= lo) return;
            if (hi <= lo + CUTOFF) { 
                insertionSort(dst, lo, hi);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(dst, src, lo, mid);
            sort(dst, src, mid+1, hi);
            if (!(src[mid+1]< src[mid])) {
                System.arraycopy(src, lo, dst, lo, hi - lo + 1);
                return;
            }

            merge(src, dst, lo, mid, hi);
        }
        public static void sort(int[] a) {
            int[] aux = a.clone();
            sort(aux, a, 0, a.length-1);  
        }

        // sort from a[lo] to a[hi] using insertion sort
        private static void insertionSort(int[] a, int lo, int hi) {
            for (int i = lo; i <= hi; i++)
                for (int j = i; j > lo && (a[j]< a[j-1]); j--)
                    exch(a, j, j-1);
        }
        private static void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
        private static void show(Object[] a) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
        }
        
    public static void main(String[] args) throws FileNotFoundException {

    	   Random rand = new Random(); 
    	   File testa = new File("/Users/ahmed/Desktop/Eclipse/Labb2/data.txt");
	       int numbersArray[]=new int [100000];
	       int numbersArray1[]=new int [100000];

	       int a=0;
	       
	     Scanner reader = new Scanner (testa);
	   	while (reader.hasNextLine()) {
	   		numbersArray[a]=reader.nextInt();
	   		numbersArray1[a]=numbersArray[a];
	   		a++;
	   		
	   	}
	   	reader.close();
	       
	    /*   for (int i=0; i< length; i++) {
	    	   numbersArray[i]= rand.nextInt(10000);
	    	   numbersArray1[i]= numbersArray[i];
	       }*/
	   	
	   		//beräkna tiden för MergeX med cut off
	       Stopwatch timer = new Stopwatch();
	       sort(numbersArray);
	       double time = timer.elapsedTime();
	       System.out.println("The execution time for cutoff is "+ time + " Second");
	       //för Merge utan cut off
	       Stopwatch timer1 = new Stopwatch();
	       sort(numbersArray1);
	       double time1 = timer1.elapsedTime();
	       System.out.println("The execution time for Merge is "+ time1 + " Second");
	       
    	}
    }
