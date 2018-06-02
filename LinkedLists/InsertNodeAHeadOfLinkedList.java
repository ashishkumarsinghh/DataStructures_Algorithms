 //Insert new node at head  
//https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
 static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if(llist == null){
            SinglyLinkedListNode n = new SinglyLinkedListNode(data);
            return n;
        }
        else{
             SinglyLinkedListNode temp = llist;
             SinglyLinkedListNode head = new SinglyLinkedListNode(data);
             head.next = temp;
             return head;
        } 

    }
