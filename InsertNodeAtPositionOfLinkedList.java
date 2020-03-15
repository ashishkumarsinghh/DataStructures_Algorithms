// insert node at a given position in linked list
   //https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

 static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode tbi = new SinglyLinkedListNode(data);
        int pos = 0;
        SinglyLinkedListNode node = head;
        while(pos < position-1){
            node = node.next;
            ++pos;
        }
        SinglyLinkedListNode temp = node.next;
        node.next = tbi;
        tbi.next = temp;
        return head;
    }
