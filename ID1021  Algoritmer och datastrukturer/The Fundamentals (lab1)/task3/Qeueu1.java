/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uptadering av koden  har gjort den 2021/09/14
 * Koden har gjort på egenhand med hjälp av kurslitteratur och disksionen med andra klasskamrater 
 */


package task3;

import java.util.Iterator;
import java.util.Scanner;

import task4.iterable1.Node;

//Skapa qeueu
public class Qeueu1 <DataType> {
	//inhållet för qeueu 
	    Node<DataType> first;
	    int length;
//node egenskap
	    public class Node<DataTyp> {
	        DataTyp value;
	        Node<DataTyp> prev;
	        Node<DataTyp> next;

//konstrakt
	        public Node(DataTyp newData) {
	           prev = null;
	           next = null;
	           value = newData;
	        }
	    }
//enqueue som fyllar noden med datat av typen  DataType alltså alla möjliga data
	        public void enqueue(DataType data) {

	        Node <DataType> newNode = new Node <DataType> (data);
	        //sätta in datan i första noden
	        if (length == 0) {
	        	first = newNode;
	            } 
	        //längden är 1
	        else if (length == 1) {

	                first.next = newNode;
	                newNode.prev = first;
	                first.prev = newNode;
	                newNode.next = first;
	            }
	        //När längden mer än 1
	            else  {
	                newNode.prev = first.prev;
	                first.prev.next = newNode;
	                first.prev = newNode;
	                newNode.next = first;
	            }
	        //incrementera längden med varje gång kommer in i loopen
	            length++;
	        }
	        //ta bort den första noden dvs FIFO
	        public DataType dequeue(){
	            DataType oldValue = (DataType) first.value;
	            if (length == 0){
	                System.out.println("Queue is empty, go home.");
	            } else if(length == 1) {
	                first = null;
	            }
	            else if(length > 1) {
	                first.prev.next = first.next;
	                first.next.prev = first.prev;
	                first = first.next;
	            }
	            length--;
	            return oldValue;
	        }
	        //bestäma sizen för qeueu genom att retunera längden
	        public int size(){
	        return length;
	        }
	        public boolean isEmpty(){
	            return first == null;
	        }
	        
	        public void print() {
	        	Node temp = first;
	        	int x=length;
	        	while (x >0) {
	        	System.out.print("["+ temp.value + "]" + ",");
	        		temp = temp.next;
	        		x--;
	        		}
	        }

	    public static void main(String[] args){
	    	Qeueu1 <Character> myList = new Qeueu1<Character>();
	        System.out.println("Enter a string  ");
	        Scanner scan = new Scanner(System.in);
	        String word = scan.nextLine();
	        char [] charArray = word.toCharArray();
	       for(int i=0; i<charArray.length; i++) {
	    	   myList.enqueue(charArray[i]);
	    	  
		        
	       }
	       for(int i=0; i<charArray.length; i++) {
	       myList.print();
	       System.out.println("The Qeueu has length:"+ myList.size());
	       System.out.println("Next that will be deleted is[ " + myList.dequeue()+"]");
	       System.out.println();
	       }

		
		}
}
