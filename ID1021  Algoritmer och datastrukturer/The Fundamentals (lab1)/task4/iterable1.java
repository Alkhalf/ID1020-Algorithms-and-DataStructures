/*@author Ahmed Alkhalaf
 * Koden har skapat den 2021/09/05
 * sista uptadering av koden  har gjort den 2021/09/14
 * Koden har gjort på egenhand med hjälp av kurslitteratur och disksionen med andra klasskamrater 
 */

package task4;
public class iterable1<DataType> {
    Node<DataType> first;
    Node<DataType> last;
    int length;

    public class Node<DataType>{
        DataType data;
        Node<DataType> next;

        public Node(DataType newData){
            this.data = newData;
            this.next = null;
        }
    }

    public void addLast (DataType newValue){
        Node<DataType> addedData = new Node(newValue);
        if (length != 0){
            last.next = addedData;
            last = last.next;
            last.next =first;
        } else {
        	first = addedData;
            last = first;
            last.next = first;
        	
        }
        length++;
    }
    
    public DataType removeLast(){
        DataType removedData = last.data;
        if (length == 0) {

        } else if (length == 1) {
            last = null;
            first = null;
        } else if(length <= 2) {
            last = first;
        } else {
            Node<DataType> temp = first;
            while (temp.next.next != last){
                temp = temp.next;
            }
            temp.next.next = first;
            last= null;
            last = temp.next;

        }
        length--;
        return removedData;
    }



    public void addFirst(DataType newValue){
        Node<DataType> newNode = new Node(newValue);
        if (length == 0){
            first = newNode;
            last = first;
            last.next = first;
        } else {
        	
            newNode.next = first;
            first = newNode;
            last.next = first;
        }
        length++;
    }
    
    public DataType removeFirst(){
        DataType removedValue = first.data;
        first = first.next;
        last.next = first;
        length--;
        return removedValue;
    }




    public int size(){
      return length;
    }
    public void print() {
    	
    	Node temp=first;
    	while (temp!=last) {
    	System.out.print("["+ temp.data + "]"+ ",");
    		temp = temp.next;
}
    System.out.print("["+ temp.data + "]" + ",");
    	
    	

	
}
    public static void main(String[] args){
    	
 
        
    String []stringArray = {"A","B", "C","D"};
    iterable1<String> obList = new iterable1<String>();
    iterable1<String> obList2 = new iterable1<String>();
    
    
    for(int i = 0; i < stringArray.length; i++){
        obList.addLast(stringArray[i]);
        obList.print(); 
    	System.out.println();
      }
    for (int j =1; j <stringArray.length ; j++) {	
    	obList.removeLast();
    	obList.print(); 
    	System.out.println();
  	
     }

      System.out.println();

      
     
     for(int k = 0; k < stringArray.length; k++){
          obList2.addFirst(stringArray[k]);
          obList2.print(); 
      	System.out.println();
      }
 
        for (int j =1; j < stringArray.length; j++){
        	obList2.removeFirst();
          	obList2.print(); 
          	System.out.println();
        }
      

    }
}
