#https://leetcode.com/problems/reverse-linked-list/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        elif head.next == None:
            return head
        else:
            x = self.reverseList(head.next)
            head.next.next = head
            head.next = None
            return x
            