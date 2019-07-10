"""
Jared's Google interview question
The binary tree is complete and it is numbered 1-x
x being the last node
Example:
            1
        2       3
     4     5  6    7 and so on
Write a program that finds if a node is in the tree or not in log n time
"""
import math

def findNode(node):
    val = node.val
    path = []
    while val != 1:
        path.append(val)
        if val % 2 != 0:
            val = (val - 1) / 2
        else:
            val = val / 2
    path = path[::-1]
    currNode = head
    for num in range(len(path) - 1):
        if currNode is None:
            return False
        if num % 2 == 0:
           currNode = currNode.left
        else:
            currNode = currNode.right
    return currNode.val == node.val

class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right

class Tree:
    def __init__(self, Node):
        self.head = Node

    def add(self, Node):
        curr = self.head
        if self.partiallyFiled(curr):
            if curr.left is None:
                curr.left = Node
                return True
            else:
                curr.right = Node
                return True
        val = addHelper(self, curr.left, Node)
        if not val:
            return addHelper(self, curr.right, Node)
        else:
            return val

    def addHelper(self, head, Node):
        curr = head
        if self.partiallyFiled(curr):
            if curr.left is None:
                curr.left = Node
                return True
            else:
                curr.right = Node
                return True
        val = addHelper(self, curr.left, Node)
        if not val:
            return addHelper(self, curr.right, Node)
        else:
            return val

    def partiallyFiled(self, node):
        if (node.left is None or node.right is None):
            return True
        return False
