/*@author Ahmed Alkhalaf
 * Task1 i labb 2
 * Denna kod är implementation för insertion Sort med tillägg som skrivar ut antal swaps 
 * som gör verje itration och skriva ut array som sorteras en gång innan sortering 
 * och engång vid varje elments byte.
 * Koden gjorde helt på egenhand med respekt för insertion algorithm ocg desktion med andra klass kamrater.
 * Koden skapade den 2021/09/18
 * Sista upptadering 2021/09/25
 * 
 */


package task1;

import java.util.Scanner;

public class insertionsort {
	
	public static void sort(int []array) {
		int swapCounter=0;
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
					swapCounter++;
					//skriva ut array efter varje ittration
					 for (int h=0; h< array.length; h++) 
							System.out.print("[" + array[h]+ "]");
						System.out.println(  " there is " + swapCounter+" swap");
				}
				
				
			}
		}
	}
	
public static void main (String []args) {
	
	System.out.println("How many number do you want to sorrt?");
       int N = new Scanner(System.in).nextInt();
       int numbersArray[]=new int [N];
   	System.out.println("Enter the numbers");

       for (int i=0; i<=N-1; i++) {
    	   int numbers = new Scanner(System.in).nextInt();
    	   numbersArray[i]=numbers;
       }
       
	   System.out.println("The array that you enterd is:");
       for (int i=0; i<=N-1; i++)
    	   System.out.print("[" + numbersArray[i] + "]");
	   System.out.println();

       sort(numbersArray);
	}
}
