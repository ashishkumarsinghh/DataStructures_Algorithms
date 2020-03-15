
/* https://www.geeksforgeeks.org/double-elements-and-append-zeros-in-linked-list/ */
package SelfPractice;
import java.util.Scanner;

public class DoubleElementsAndAppendZeroes {

	public static SLLNode head;
	public static Scanner in;
	public static void main(String[] args){
		head = new SLLNode();
		in = new Scanner(System.in);
		//how many elements in the linked list
		int n = in.nextInt();
		//create the linked list by adding the elements at the end using the input() function.
		input(n);
		in.close();
		SLLNode curr = head;
		//check for curr.next for null as curr.next could be null and then checking for curr.next.next can result in NullPointerException
		while(curr != null && curr.next != null && curr.next.next != null){
			//check for the condition number -> number -> 0, We will modify only if this pattern is there.
			if(curr.data == curr.next.data && curr.next.next.data == 0){
				//double the current node data and make the next node data to 0
				curr.data = curr.data * 2;
				curr.next.data = 0;
				//move current node to next next as next was same and next next was zero (as per the pattern)
				curr = curr.next.next.next;

			}
			else{
				//move current node to next node to find the pattern
				curr = curr.next;
			}
		}
		
		//move all zero nodes to the end
		
		//store how many zeroes are there
		int countOfZeroNodes = 0;
		
		//start from the head node
		curr = head;
		//if there are zero nodes at the starting then you need to change the head to the first non zero node
		while(curr.data == 0){
			curr = curr.next;
			countOfZeroNodes++;
		}
		head = curr;
		
		//check for zero nodes after the head node
		while(curr != null && curr.next != null && curr.next.next!=null){
			if(curr.next.data == 0){
				curr.next = curr.next.next.next;
				countOfZeroNodes+=2;
			}
			curr = curr.next;
		}
		
		for(int j = 0; j< countOfZeroNodes; j++){
			head.addAtEnd(new SLLNode(0));
		}
				
		head.printLL();
		
	}
	
	public static void input(int n){
		for(int i = 0; i <n ; i++){
			int value = in.nextInt();
			//create a new node with the input value
			SLLNode newNode = new SLLNode(value);
			//add the node at the end of the list
			head.addAtEnd(newNode);
		}
	}
}
