public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // like binary search
        // the midpoint of each half of the linkedlist will be the node 
        // the left of the node will be the midpoint of the left half
        // the right of the node will the midpoint of the right half
        if (head == null) return null;
        return convert(head, null);
    }
    
    public TreeNode convert(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode slow = head;
        ListNode fast = head;
        // this is the method to get the midpoint of a linked list
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode t = new TreeNode(slow.val);
        t.left = convert(head, slow);
        t.right = convert(slow.next, end);
        return t;
    }
}