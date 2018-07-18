

package SelfPractice;
import java.util.Scanner;

public class FloydCycleDetectRemove {

	public static Scanner in;
	public static SLLNode head;
	public static void main(String[] args){
		in = new Scanner(System.in);
		head = new SLLNode();
		//how many elements in the linked list
		int n = in.nextInt();
		//create the linked list by adding the elements at the end using the input() function.
		input(n);
		in.close();
		//create a cycle by setting the node next
		createCycle();
		
		SLLNode curr = head;
		//detect cycle
		SLLNode slowPtr, fastPtr;
		slowPtr = head;
		fastPtr = head.next;
		while(slowPtr != null && fastPtr!=null && fastPtr.next!=null){
			if(slowPtr.data == fastPtr.data){
				slowPtr = head;
				System.out.println("Loop detected." +" fastPtr at "+ fastPtr.data);
				break;
				
			}
			else{
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
			}
		}
		
		while(fastPtr.next.data != slowPtr.data){
			System.out.println("fast :" + fastPtr.data +" slow : "+slowPtr.data);
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		//remove the loop
		fastPtr.next = null;
		head.printLL();
	}
	
	
	public static void createCycle(){
		head.next.next.next.next = head.next.next;
		System.out.println("created loop at "+head.next.next.next.data +" to "+ head.next.data);
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
