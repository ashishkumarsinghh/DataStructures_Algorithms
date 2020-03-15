/*https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem */
/* reverse print the elements of linked list */   
 static void reversePrint(SinglyLinkedListNode head) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        while(head != null){
            a.add(head.data);
            head = head.next;
        }
        int j = a.size()-2;
        SinglyLinkedListNode nodeHead = null, moving = null;
        nodeHead = new SinglyLinkedListNode(a.get(a.size()-1));
        moving = nodeHead;
        while(j >= 0){
            moving.next = new SinglyLinkedListNode(a.get(j));
            moving = moving.next;
            j--;
        }
        moving.next = null;
        printSinglyLinkedList(nodeHead, "\n"); 
        System.out.println();
    }
