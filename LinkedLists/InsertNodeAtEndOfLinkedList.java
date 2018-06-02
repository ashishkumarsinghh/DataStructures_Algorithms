//Add node to the end of LinkedList
//https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
  

static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = head;
        if(node == null){
            head = new SinglyLinkedListNode(data);
            return head;
        }
        else{
            while(node.next != null){
                node = node.next;
            }
            SinglyLinkedListNode n = new SinglyLinkedListNode(data);
            node.next = n;
            return head;
        }

    }
