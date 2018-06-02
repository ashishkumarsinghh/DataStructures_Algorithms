     /* https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem */
// Delete a node from linked list at Position
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    
        int pos = 0;
        SinglyLinkedListNode node = head;
        if(position ==0){
            head = head.next;
        }
        else{
        while(pos<position-1){
            node = node.next;
            pos++; 
        }
        if(node.next != null){
            SinglyLinkedListNode temp = node.next.next;
            node.next = temp; 
        }
        else
            node.next = null;
        
        }

        return head;

    }
