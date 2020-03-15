

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
		//take a slow moving pointer and fast moving pointer, fast will move at twice the speed of slow.
		slowPtr = head;
		fastPtr = head.next;
		while(slowPtr != null && fastPtr!=null && fastPtr.next!=null){
			//if fast and slow meet, that is same data is present on fast and slow then there is a loop.
			if(slowPtr.data == fastPtr.data){
				//reset slow pointer in order to check for the point where the loop has started
				slowPtr = head;
				System.out.println("Loop detected." +" fastPtr at "+ fastPtr.data);
				break;
				
			}
			else{
				//move slow pointer by 1 and fast pointer by 2.
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
			}
		}
		
		while(fastPtr.next.data != slowPtr.data){
			//move both the pointers by 1, they will meet at the loop starting point.
			//let n be cycle length, k where the fast.data was equal to slow.data, m be the start of loop. m+k is multiple of n.
			// if m+k is multiple of n, we can reason that m = n-k because m+k = n => m = n-k
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
