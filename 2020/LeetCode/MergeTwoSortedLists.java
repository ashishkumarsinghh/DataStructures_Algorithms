//https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (head == null) {
                if (l1.val < l2.val) {
                    head = l1;
                    l1 = l1.next;
                    curr = head;
                } else {
                    head = l2;
                    l2 = l2.next;
                    curr = head;
                }
            } else {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                    curr = curr.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                    curr = curr.next;
                }
            }
        }

        while (l1 != null) {
            if (head == null) {
                head = l1;
                curr = head;
                l1 = l1.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }

        }

        while (l2 != null) {
            if (head == null) {
                head = l2;
                curr = head;
                l2 = l2.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }

        }
        return head;
    }
}