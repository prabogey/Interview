public class BinarySearchTree<T> {
    BSTNode<T> root;
    int size;

    public BinarySearchTree(T data) {
        BSTNode<T> newNode = new BSTNode<>(data);
        add(data);
    }

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Your data is null");
        }
        if (root == null) {
            this.root = new BSTNode<T>(data);
            size++;
            return;
        }
        root = addHelper(data, root);
    }

    /**
     * Recursive add helper
     * @param data data that needs to be added
     * @param curr current node that is being visited
     * @return node that was added
     */
    private BSTNode<T> addHelper(T data, BSTNode<T> curr) {
        if (curr == null) {
            size++;
            return new BSTNode<>(data);
        }
        if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(addHelper(data, curr.getRight()));
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(addHelper(data, curr.getLeft()));
        }
        return curr;
    }

    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data you passe din was "
                    + "null");
        }
        if (root == null) {
            throw new NoSuchElementException("The element was not found in "
                    + "the list because the list is empty");
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = removeHelper(data, root, dummy);
        size--;
        return dummy.getData();
    }

    /**
     * This is a helper method that removes and replaces a node correctly
     * @param data the data that needs to be removed from tree
     * @param curr the current node that is being visited
     * @param dummy the dummy node in which the data is stored
     * @return the data that is successfully removed
     */
    private BSTNode<T> removeHelper(T data, BSTNode<T> curr, BSTNode<T> dummy) {
        if (curr == null) {
            throw new NoSuchElementException("The data you passed in, "
                    + "was not " + "found in the tree");
        }
        if (data.compareTo(curr.getData()) > 0) {
            // if the data is greater than the current node
            curr.setRight(removeHelper(data, curr.getRight(), dummy));
        } else if (data.compareTo(curr.getData()) < 0) {
            // if the data is less than the current node
            curr.setLeft(removeHelper(data, curr.getLeft(), dummy));
        } else {
            //set the dummy's data to the node that is being removed data
            dummy.setData(curr.getData());
            if (curr.getRight() != null && curr.getLeft() == null) {
                // left is null, right is not
                return curr.getRight();
            } else if (curr.getLeft() != null && curr.getRight() == null) {
                // right is null, left is not
                return curr.getLeft();
            } else if (curr.getRight() == null && curr.getLeft() == null) {
                // both children are null, just return null
                return null;
            } else {
                // find the predecessor
                BSTNode<T> predecessorParent = curr;
                BSTNode<T> predecessor = curr.getLeft();
                while (predecessor.getRight() != null) {
                    predecessorParent = predecessor;
                    predecessor = predecessor.getRight();
                }
                if (predecessorParent.getRight().equals(predecessor)) {
                    // if the parent node's right equals the predecessor then
                    // set the right of the parent to the left of the
                    // predecessor to preserve the left tree of predecessor
                    predecessorParent.setRight(predecessor.getLeft());
                } else {
                    // set the left of the predecessorParent to the left of
                    // the predecessor
                    predecessorParent.setLeft(predecessor.getLeft());
                }
                // set the current nodes data to the predecessor's data
                curr.setData(predecessor.getData());
            }
        }
        return curr;
    }
}