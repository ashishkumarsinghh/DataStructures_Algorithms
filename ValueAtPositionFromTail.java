/*https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem */
// get value at given position from tail of linked list   
 static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        while(head != null){
            ar.add(head.data);
            head = head.next;
        }
        return ar.get(ar.size()-1-positionFromTail);

    }
