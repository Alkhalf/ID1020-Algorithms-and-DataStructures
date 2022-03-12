/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uptadering av koden  har gjort den 2021/09/14
 * Koden har gjort på egenhand med hjälp av kurslitteratur och disksionen med andra klasskamrater 
 */

package task2;

import java.util.Scanner;

public class Stack {
	//Skapa stack ihållet
	Node first;
    int length;
    //skapa Node inhållet
    private class Node {
        char token;
        Node next;
        //Sätta i character i noden
        public Node(char character){
            this.token = character;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }
    
    //Pusha input inut i stacken 
    public void push (char ch){
    	//stack är tom, skapa ny node
    	Node oldNode=first;
    	Node newNode = new Node(ch);
        first = newNode;
        first.next = oldNode;
        length++;
    
    }

    public char pop() {
    	
    	char item = first.token;        
        first = first.next;           
        length--;
        return item; 
       
       

    }
    public int size(){
        return length;
    }
    public static void main( String[] args) {
        System.out.println("Enter a word to revers");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        char [] charArray = word.toCharArray();
       

        Stack MainStack = new Stack();
        
        for(int i = 0; i < charArray.length; i++){
            MainStack.push(charArray[i]);
        }
        System.out.println("The stack size is "+ MainStack.size());
        
        int stacksize= MainStack.size();
        for (int j =0; j < stacksize; j++){
            System.out.print(MainStack.pop());   
        }
        System.out.println();
        if(MainStack.isEmpty()){
            System.out.println("The stack is empty now");
        }
    }
}