/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uppdatering av koden har gjort den 2021/09/14
 * Koden har gjort på egenhand med hjälp av kurslitteratur och disksionen med andra klasskamrater 
 */
package task2;
import java.util.Scanner;
public class recrusivRevers {

		public static void reverseWord(char []character,int pos) {
			if (pos>=0)
			{
				System.out.print(character[pos--]);
				reverseWord(character,pos);	
			}
		}
		public static void main (String []args)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter A Word");
			char[] stringword = in.nextLine().toCharArray();
			int pos1 = stringword.length-1;
			reverseWord(stringword,pos1);
		 	
	}

}

/*
Node t


 
*/