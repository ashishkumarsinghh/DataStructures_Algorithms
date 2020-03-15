/*https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem */
/*delete duplicate nodes from sorted linked list */  

  static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head.next, prevNode = head;
        int prev = head.data;
        while(curr != null){
            if(prev == curr.data){
                prevNode.next = curr.next;
                curr = curr.next;
            }
            else{
            prev = curr.data;
            prevNode = curr;
            curr = curr.next;  
            }

        }
        return head;
    }
