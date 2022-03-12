package task4;
import java.util.Random;

import java.util.Scanner;

public class insertion {
		
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
					}
					
				}
			}
			
		}
		public static void print (int []numbersArray) {
			for (int h=0; h< numbersArray.length; h++) 
				System.out.print(numbersArray[h]);
			System.out.println();


		}
}