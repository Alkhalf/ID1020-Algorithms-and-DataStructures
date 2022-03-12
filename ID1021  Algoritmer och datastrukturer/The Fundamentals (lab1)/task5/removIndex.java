/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uptadering av koden  har gjort den 2021/09/14
 * Koden har gjort på egenhand med hjälp av kurslitteratur och disksionen med andra klasskamrater 
 */


package task5;

import java.util.Scanner;

public class removIndex<DataType> {

        Node<DataType> first;
        Node<DataType> last;
        int length;


        public class Node<DataType> {
            DataType data;
            Node<DataType> next;

            public Node(DataType newData) {
                this.data = newData;
                this.next = null;
            }
        }

//add a node at last of the Qeueu 
        public void add (DataType newValue){
        Node<DataType> newNode = new Node(newValue);
        if (length != 0){

            last.next = newNode;
            last = last.next;
            last.next =first;
           
        } else {
        	 first = newNode;
             last = first;
             last.next = first;
        }
        	length++;
        }


        public DataType removeItem(int index){
            DataType removedNode=null;
            Node<DataType> temp = first;
           if (index==1) {
        	   removedNode=first.data;
        	   first=first.next;
          }
           else if (index < length) { 
         	  
        	   int i = 1;
        	   while (i != (index-1) )
        	   {
        		   temp = temp.next;
        		   i++;
        		   
        	   }
        	   temp.next = temp.next.next;
               removedNode = temp.data;

           }
           //last index
           else 
           {
        	   while ( temp.next!=last)
        	   { temp = temp.next; }
        	   
               removedNode = temp.next.data;
        	   last= temp;
        	   last.next=first;
        	   
        	   
           }
          
           length--;
           return removedNode;
        }


        public void print(){
            Node<DataType> temp = first;
            System.out.print("{" + temp.data + ", " );
            while (temp.next != last){
                temp = temp.next;
                System.out.print(temp.data + ", ");
            }
            System.out.print(last.data + "}");
        }

        public int size(){
            return length;
        }

        public boolean isEmpty(){
            return length == 0;
        }

    public static void main(String[] args) {
        removIndex<Character> obList = new removIndex();
        System.out.println("Enter a string ");
        String word = new Scanner(System.in).nextLine();
        char [] charArray = word.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            obList.add(charArray[i]);
        }
        System.out.println("The string which you entered is:");
        obList.print();
        System.out.println();

        System.out.println("Enter the index from your word that you need to delete ");
        int index = new Scanner(System.in).nextInt();
        System.out.println();
        obList.removeItem(index);
        System.out.println("The elements which is saved is: ");
        obList.print();
    }
}




