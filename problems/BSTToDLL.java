    // converting binary search tree to Doubly Linked List

    public class BSTToDLL {
        public static Node constructDLL(BSTNode root) {
            // recursively create the doubly linked list
            Node mid = new Node(root.val);

            Prev prev = new Prev(null);
            Node left = helper(root.left, prev);
            prev.node.next = mid;
            mid.prev = prev.node;
            prev.node = mid;
            Node right = helper(root.left, prev);
            mid.next = right;
            return prev.head;
        }

        public static Node helper(BSTNode start, Prev prev) {
            if (start == null) return null;
            Node node = new Node(start.val);
            if (start.left == null && start.right == null) {
                if (prev.node == null) {           
                    prev.node = node;
                    prev.head = node;
                    return node;
                }
                node.prev = prev.node;
                prev.node = node;
                return node;
            }
            Node left = helper(start.left, prev);

            prev.node.next = node;
            node.prev = prev.node;
            prev.node = node;

            Node right = helper(start.right, prev);
            node.next = right;
            return node;
        }

        // This is a static class that stores the last node seen in a recursive stack
        // this is helpful to set the next and prev whenever you are returning up
        static class Prev {
            Node node;
            Node head;
            public Prev(Node node) {
                this.node = node;
            }
        }
    }