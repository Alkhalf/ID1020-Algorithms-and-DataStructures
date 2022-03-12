package task4;
import java.util.Random;
import java.util.Scanner;

public class Quick {
	public static void sort(int[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int partition(int[] a, int lo, int hi) {
        int i = lo; //0
        int j = hi + 1;
        int v = a[lo]; //4
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
           System.out.print(a[i]);
        }
    }
    
    
 
 }