package task4;

import java.util.Random;
import java.util.Scanner;

public class Merge {

    public static void sort(String[] a) {
        String[] aux = new String [a.length];
        sort(a, aux, 0, a.length-1);
        
    }
    private static void sort(String[] a, String[] aux, int lo, int hi) {
    	//när array består av en element bara
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //sortera höger delen av arrayen
        sort(a, aux, lo, mid);
        //sortera vänster delen av arrayen
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(String [] a, String[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
        	//när når halva array börja fylla till vänster delen
            if      (i > mid)  
            	a[k] = aux[j++];
        	//när når halva array börja fylla till höger delen

            else if (j > hi)     
            	a[k] = aux[i++];
            //om elementen som finns i höger array > vänster fylla den i höger delen av orginal array
            else if (aux[j].compareTo(aux[i]) < 0)
           // else if (aux[j]< aux[i])
            	a[k] = aux[j++];
            // fylla elementen i höger delen av orginal array
            else                        
            	a[k] = aux[i++];
        }
    }
    // print array to standard output
    public static void show(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i]+ "]");
        }
    }
}
/*package task4;

import java.util.Random;
import java.util.Scanner;

public class Merge {

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
        
    }
    private static void sort(int[] a, int[] aux, int lo, int hi) {
    	//när array består av en element bara
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //sortera höger delen av arrayen
        sort(a, aux, lo, mid);
        //sortera vänster delen av arrayen
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int [] a, int[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
        	//när når halva array börja fylla till vänster delen
            if      (i > mid)  
            	a[k] = aux[j++];
        	//när når halva array börja fylla till höger delen

            else if (j > hi)     
            	a[k] = aux[i++];
            //om elementen som finns i höger array > vänster fylla den i höger delen av orginal array
            else if (aux[j]< aux[i])
            	a[k] = aux[j++];
            // fylla elementen i höger delen av orginal array
            else                        
            	a[k] = aux[i++];
        }
    }
    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i]+ "]");
        }
    }
}*/