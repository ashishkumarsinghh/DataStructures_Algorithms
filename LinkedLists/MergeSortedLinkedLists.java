/* https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem */ 
/* merge two sorted linked lists */
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        if(head1 == null && head2 != null){
            head = head2;
            return head;
        }
        else if(head1!=null && head2 == null){
            head = head1;
            return head;
        }
        else{
            if(head1.data < head2.data){
                head = new SinglyLinkedListNode(head1.data);
                head1 = head1.next;
            }
            else{
                head = new SinglyLinkedListNode(head2.data);
                head2 = head2.next;
            }
            SinglyLinkedListNode curr = head;
            while(true){
                if(head1 == null && head2 == null){
                    break;
                }
                else if(head1 == null){
                    curr.next = new SinglyLinkedListNode(head2.data);
                    head2 = head2.next;
                    curr = curr.next;
                }
                else if(head2 == null){
                    curr.next = new SinglyLinkedListNode(head1.data);
                    head1 = head1.next;
                    curr = curr.next;
                }
                else{
                    if(head1.data <= head2.data){
                        curr.next = new SinglyLinkedListNode(head1.data);
                        head1 = head1.next;
                        curr = curr.next;
                    }
                    else{
                        curr.next = new SinglyLinkedListNode(head2.data);
                        head2 = head2.next;
                        curr = curr.next;
                    }
                }
            }
            return head;
        }

    }
