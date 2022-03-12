/*@author Ahmed Alkhalaf
 * Task 2 i labb 2
 * Denna kod är implementation för insertion Sort med tillägg som skrivar ut 
 * list av invetions  som kan finnas i en array och skriva ut array som sorteras en gång innan sortering 
 * och engång vid varje elments byte.
 * Koden gjorde helt på egenhand med respekt för insertion algorithm ocg desktion med andra klass kamrater.
 * Koden skapade den 2021/09/18
 * Sista upptadering 2021/09/25
 * 
 */


package task2;

import java.util.Scanner;

import task4.Stopwatch;

public class task2 {
	
	public static void sort(int []array) {

		//yttreloop för att gå igenom alla elementer
		for (int i=0; i< array.length; i++) {
			//innreloop för att jämföra varje gång elementen med alla elementer
			for (int j=i; j>0; j--) {
				
				//byta plats på två elementer
				if (array[j] < array[j-1])
				{
					int temp= array[j];
					array[j]=array[j-1];
					array[j-1]= temp;
					print (array );
					
				}
				
				
			}
		}
	}
	public static void print (int []array) {
		
		for (int h=0; h< array.length; h++) 
			System.out.print("[" + array[h]+ "]");
	 System.out.println();
		
	}
	public static void inver(int []array) {
		
		for (int i=0; i< array.length-1; i++) {
			//innreloop för att jämföra varje gång elementen med alla elementer
			for (int j=i+1; j<array.length; j++) {
				if (array[i]>array[j]) 
					printInver(array[i], i, array[j], j);

				
			}
		}
		
	}
	public static void printInver (int arrayI, int i, int arrayJ, int j) {
		System.out.println("["+ i+"," + arrayI+"]"
	+" [" +j+ ","+ arrayJ+"]" );
	}

public static void main (String []args) {
	
	System.out.println("How many numbers do you want to sorrt?");
       int N = new Scanner(System.in).nextInt();
       int numbersArray[]=new int [N];
   	System.out.println("Enter the numbers");

       for (int i=0; i<=N-1; i++) {
    	   int numbers = new Scanner(System.in).nextInt();
    	   numbersArray[i]=numbers;
       }
       
	   System.out.println();
       for (int i=0; i<=N-1; i++)
    	   System.out.print("[" + numbersArray[i] + "]");
	   System.out.println();
	   inver(numbersArray);
	   System.out.println("**************************");
       sort(numbersArray);
      
	}
}
