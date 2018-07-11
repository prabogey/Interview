import java.util.PriorityQueue;

public class LinkedListProblems {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElementsRecursive(head.next, val);
        head.next = removeElementsRecursive(head.next, val);
        return head;
    }

    public static ListNode mergeKLists(ListNode[] list) {
        PriorityQueue<ListNode> sorted = new PriorityQueue<>();
        TreeNode head = new TreeNode(0);
        for (ListNode curr: list) {
            if (curr) {
                sorted.add(new Entry(curr.val, curr));
            }
        }
        TreeNode curr = head;
        while(!sorted.isEmpty()) {
            Entry pulled = sorted.remove();
            TreeNode node = pulled.node;
            TreeNode add = node.next;
            curr.next = node;
            curr = curr.next;
            if (add) {
                sorted.add(new Entry(add.val, add));
            }
        }
        return head.next;
    }

    // returns true if the linkedlist has a cycle or not
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.equals(slow)) {
                return true;
            }
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return false;
    }

    // returns the node where the cycle begins
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // the reason we do this to find the node where the cycle start is that, the total distance slow travelled is a + b
                // the total distance fast traveled is a + 2b + c == 2(a + b), c == a
                // so you create a head pointer, and keep incrementing it, it will end up travelling a distance, at the same time
                // the other slow pointer will travel c distance, along a cycle
                // this means that they will meet at the point when the cycle starts
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    // this function checks if a certain linkedlist is a palindrome or not
    // does it in O(n) extra space and O(n) time
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode last = head;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }
        int[] vals = new int[size];
        int i = 0;
        last = head;
        while (last != null) {
            vals[i] = last.val;
            last = last.next;
            i++;
        }
        i = 0;
        int j = vals.length - 1;
        while (i < vals.length && j >= 0) {
            if (!(vals[i] == vals[j])) {
                return false;
            }
            i++;
            if (i == j) {
                return true;
            }
            j--;
        }
        return true;
    }

    // TODO: same problem as above but with O(1) extra space
    public boolean isPalindromeNoSpace(ListNode head) {
        // find the midpoint
        // reverse everything before the midpoint 
        // compare from the reversed list (0 -> midpoint)
        // and the non reversed one (midpoint -> end)
    }

    // find the node where the two nodes intersect
    // do not use extra space. and do it in linear time
    // the main part of the problem here is that one ListNode (a or b) may have different lengths to reach the intersection point
    // A might be a->a->c
    // B might be b->c
    // so you cant just linearly iterate through and just return when they are equal
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // find length of two lists
        // align them at the same starting length
        // then check for intersection
        int lenA = length(headA);
        int lenB = length(headB);
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

class Entry implements Comparable<Entry> {
    public int val;
    public ListNode node;

    public Entry(int x, int n) {
        this.val = x;
        this.node = n;
    }

    @Override
    public int compareTo(Entry other) {
        return (this.val <= other.val) ? -1 : 1;
    }

}