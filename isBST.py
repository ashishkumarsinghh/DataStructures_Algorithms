#https://www.hackerrank.com/challenges/is-binary-search-tree/problem
""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def checkBST(node, lmin, lmax):
    if node == None:
        return True
    else:
        if node.data > lmin and node.data < lmax:
            return checkBST(node.left, lmin, node.data) and checkBST(node.right, node.data, lmax)
        else:
            return False
def check_binary_search_tree_(root):
    return checkBST(root, 0, 10000);