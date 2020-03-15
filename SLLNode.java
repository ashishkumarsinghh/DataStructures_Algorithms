package SelfPractice;

public class SLLNode{
	int data;
	SLLNode next;
	
	SLLNode(int data){
		this.data = data;
		this.next = null;
	}
	SLLNode(){
		this.data = -1;
		this.next = null;
	}
	
	public SLLNode addAtEnd(SLLNode node){
		if(this.data != -1){
			SLLNode curr = this;
			while(curr.next != null){
				
				curr = curr.next;
			}
			curr.next = node;
			return this;
		}
		else{
			this.data = node.data;
			return this;
		}

	}
	
	public void printLL(){
		SLLNode node = this;
		while(node != null){
			System.out.print(node.data +"-->");
			node = node.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
}

