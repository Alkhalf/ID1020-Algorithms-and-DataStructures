/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uptadering av koden  har gjort den 2021/09/14
 * Koden har gjort på egenhand och med diskussionen med andra klasskamrater 
 */

package task6;

import java.util.Scanner;

public class sort {
	
	    Node first;
	    Node last;
	    int length;


	    public class Node {
	    	int value;
	        Node next;
	        public Node( int newValue) {
	            this.value = newValue;
	            this.next = null;
	        }
	    }
	    public boolean isEmpty(){
	        return length == 0;
	    }
	    public int size(){
	        return length;
	    }
	    
	    
	    public void add(int newInput){
	        Node newNodeInput = new Node(newInput);
	        if(length==0){
	            first = newNodeInput;
	            last = first;
	            last.next = first;
	        } 
	        else if(length == 1){
	            if(first.value > newInput){
	                newNodeInput.next = last.next;
	                first = newNodeInput;
	                last.next = first;
	            } else {
	                first.next = newNodeInput;
	                last = newNodeInput;
	                last.next = first;
	            }
	        } 
	        else if( length > 1) {
	            if (first.value > newInput) {
	                newNodeInput.next = last.next;
	                first = newNodeInput;
	                last.next = first;
	            } 
	            else {
	                Node temp = first;
	                while (temp.next != first) {
	                    if (temp.next.value > newInput) {
	                        break;
	                    } else {
	                        temp = temp.next;
	                    }
	                }
	                Node old = temp.next;
	                newNodeInput.next = old;
	                temp.next = newNodeInput;
	                //temp.next.next = newNodeInput.next;
	                
	                if (newInput > last.value) {
	                    Node oldLast = last;
	                    oldLast.next = newNodeInput;
	                    last = newNodeInput;
	                }
	                last.next = first;
	            }
	        }
	        length++;
	    }

	    public String toStr(){
	        Node temp = first;
	        
	        int j = length-1;
	        int [] integerArray = new int[length];
	        for (int i=0; i<=j;i++) {
	            integerArray[i] = temp.value;
	            temp = temp.next;
	        }
	        return ("The integer you enterd is sorted: \n"  + java.util.Arrays.toString(integerArray));
	    }

	    public static void main(String[] args){
	    	 System.out.println("Enter 10 integer to sort");
	        sort sortQ = new sort();
	        int i =10;
	        int j;
	        while(i>0) {
	        	j= new Scanner(System.in).nextInt();
	        	 sortQ.add(j);
	        	 i--;
	        	
	        }
	        System.out.println(sortQ.toStr());
	}
}
