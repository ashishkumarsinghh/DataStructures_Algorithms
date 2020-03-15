package SelfPractice;
import java.util.Scanner;

public class MergeSortSLL {
	
	public static SLLNode head1, head2;
	
	public static Scanner in ;
	
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		head1 = new SLLNode();
		head2 = new SLLNode();
		in = new Scanner(System.in);
		int n = in.nextInt();
		//how many elements in the linked list
//		int n1 = in.nextInt();
//		//create the linked list by adding the elements at the end using the input() function.
//		input(head1, n1);
//		int n2 = in.nextInt();
//		input(head2, n2);
//		in.close();
		//test merge of 2 linked lists
		//merge(head1, head2).printLL();
		//test mergesort on new list
		input(head1, n);
		mergeSort(head1).printLL();
	}
	
	public static SLLNode mergeSort(SLLNode h){
		if(h==null){
			return null;
		}
		else if(h.next == null){
			 return h;
		}
		else{
			SLLNode midNode = findMid(h);
			if(midNode == null){
				return h;
			}
			else{
				SLLNode secondStart = midNode.next;
				//System.out.println("secondStart is "+ secondStart.data);
				midNode.next = null;
				SLLNode left = mergeSort(h);
				SLLNode right = mergeSort(secondStart);
				//System.out.println("left : " + left.data+" right: "+ right.data);
				return merge(left, right);
			}

		}

	}
	
	public static SLLNode findMid(SLLNode h){
		if(h!=null && h.next!=null){
			SLLNode slowPtr = h;
			SLLNode fastPtr = h.next;
			while(fastPtr != null && fastPtr.next != null){
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
			}
			return slowPtr;
		}
		else return null;
	}
	public static SLLNode merge(SLLNode h1, SLLNode h2){
		SLLNode h;
		if(h1 == null && h2 == null){
			return null;
		}
		else if(h2==null){
			return h1;
		}
		else if(h1==null){
			return h2;
		}
		else{
			if(h1.data < h2.data){
				h = new SLLNode(h1.data);
				h.next = merge(h1.next, h2);
			}
			else{
				h = new SLLNode(h2.data);
				h.next = merge(h1, h2.next);
			}
			return h;
		}
	}
	
	public static void input(SLLNode head, int n){
		for(int i = 0; i <n ; i++){
			int value = in.nextInt();
			//create a new node with the input value
			SLLNode newNode = new SLLNode(value);
			//add the node at the end of the list
			head.addAtEnd(newNode);
		}
	}
}
