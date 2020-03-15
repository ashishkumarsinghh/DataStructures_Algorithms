/*https://www.hackerrank.com/challenges/compare-two-linked-lists/problem */
/* comparing two linked lists */

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null && head2 == null)
            return true;
        else if((head1 == null && head2 !=null) && (head1 !=null && head2 == null))
            return false;
        else{
            while(head1 !=null || head2!=null){
                if((head1 == null && head2 !=null) || (head1 !=null && head2 == null))
                    return false;
                else if(head1.data != head2.data)
                    return false;
                head1= head1.next;
                head2 = head2.next;
            }
            return true;
        }
    }
