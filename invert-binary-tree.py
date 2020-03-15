#https://leetcode.com/problems/invert-binary-tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root == None:
            return None
        else:
            temp = root.right
            root.right = self.invertTree(root.left)
            root.left = self.invertTree(temp)
            return root