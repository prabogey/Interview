class ListNode:
    __init__(self, val):
        self.val = val
        self.next = None

def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        x = 0
        carry = 0
        head = ListNode(0)
        ret = head
        while (l1 != None or l2 != None):
            if (l2 != None and l1 != None):
                y = l1.val + l2.val + carry
                l1 = l1.next
                l2 = l2.next
            elif (l2 == None and l1 != None):
                y = l1.val + carry
                l1 = l1.next
            elif (l2 != None and l1 == None):
                y = l2.val + carry
                l2 = l2.next
            carry = y // 10
            ret.next = ListNode(y % 10)
            ret = ret.next
        
        if carry != 0:
            ret.next = ListNode(carry)
        
        return head.next
        