/*@author Ahmed Alkhalaf
 * Task 7 i labb 2
 * Denna kod är implementation för insertion sort algoritm.
 * koden sorterar en array med fallande ordning istället för stigande ordning 
 * utan ändring på själva insertion sort algoritm. 
 * Koden gjorde på egenhand med diskussion mellan klasskamrater
 * Koden skapade den 2021/09/22 
 * Sista upptadering 2021/09/25
 * 
 */


package task7;
import java.util.Scanner;


public class insertionDes {

		
		public static void sort(int []array) {

			//yttreloop för att gå igenom alla elementer
			for (int i=0; i< array.length; i++) {
				//innreloop för att jämföra varje 
				//gång elementen med alla elementer
				for (int j=i; j>0; j--) {
					
					//byta plats på två elementer
					if (array[j] < array[j-1])
					{
						int temp= array[j];
						array[j]=array[j-1];
						array[j-1]= temp;
						
						//print array vid varje byte av elementer
						print(array);
						
						 
					}
					
					
				}
			}
		}
		public static void print (int []array) {
			for (int h=0; h< array.length; h++) 
				//multplecera elementer med -1 vid utskrivning så att få de rätt
				System.out.print("[" + array[h]*(-1)+ "]");
			   System.out.println();

			
		}

	public static void main (String []args) {
		
		System.out.println("How many numbers do you want to sorrt?");
	       int N = new Scanner(System.in).nextInt();
	       int numbersArray[]=new int [N];
	   	System.out.println("Enter the numbers");
	   		//multplicera elementer med -1 så att de ordnar elementer på stigande ordning i 
	   		//algoritmen utan att ändra något på själva algoritmen
	       for (int i=0; i<=N-1; i++) {
	    	   int numbers = new Scanner(System.in).nextInt();
	    	   numbersArray[i]=numbers*(-1);
	       }
	       
		   System.out.println();
	       sort(numbersArray);
	       
		
	}

}
