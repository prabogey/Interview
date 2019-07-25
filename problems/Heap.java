// Implementing a heap

public class Heap {
    int lastIndex = 0;
    int size = 0;
    boolean min;
    int[] backingArr;

    public Heap(int size, boolean min) {
        backingArr = new int[size];
        this.min = min;
    }

    public void add(int x) {
        size++;
        if (lastIndex == 0) {
            backingArr[0] = x;
            lastIndex++;
            return;
        }
        backingArr[lastIndex] = x;
        heapify();
        lastIndex++;
    }

    public int remove() {
        int temp = backingArr[0];
        int last = lastIndex - 1;
        backingArr[0] = backingArr[last];
        backingArr[last] = 0;
        lastIndex--;
        size--;
        downHeapify();
        return temp;
    }

    public int poll() {
        return backingArr[0];
    }

    private void heapify() {
        int i = lastIndex;
        int parent = i / 2;
        if (min) {
            while (i != 0 && backingArr[i] < backingArr[parent]) {
                int temp = backingArr[parent];
                backingArr[parent] = backingArr[i];
                backingArr[i] = temp;
                i = parent;
                parent = i / 2;
            }
        } else {
            while (i != 0 && backingArr[i] > backingArr[parent]) {
                int temp = backingArr[parent];
                backingArr[parent] = backingArr[i];
                backingArr[i] = temp;
                i = parent;
                parent = i / 2;
            }
        }
    }

    private void downHeapify() {
        int start = 0;
        int leftChild = start + 1;
        int rightChild = leftChild + 1;
        if (min) {
            while (rightChild < lastIndex && (backingArr[start] > backingArr[leftChild] || backingArr[start] > backingArr[leftChild])) {
                int smallest = backingArr[start];
                int replace = start;
                if (backingArr[start] > backingArr[leftChild] && backingArr[leftChild] < smallest) {
                    replace = leftChild;
                }
                if (backingArr[start] > backingArr[leftChild] && backingArr[rightChild] < smallest) {
                    replace = rightChild;
                }
                int temp = backingArr[start];
                backingArr[start] = backingArr[replace];
                backingArr[replace] = temp;
                start = replace;
                leftChild = start + 1;
                rightChild = leftChild + 1;
            }
        } else {
            while (rightChild < lastIndex && (backingArr[start] < backingArr[leftChild] || backingArr[start] < backingArr[leftChild])) {
                int biggest = backingArr[start];
                int replace = start;
                if (backingArr[start] < backingArr[leftChild] && backingArr[leftChild] > biggest) {
                    replace = leftChild;
                }
                if (backingArr[start] < backingArr[leftChild] && backingArr[rightChild] > biggest) {
                    replace = rightChild;
                }
                int temp = backingArr[start];
                backingArr[start] = backingArr[replace];
                backingArr[replace] = temp;
                start = replace;
                leftChild = start + 1;
                rightChild = leftChild + 1;
            }
        }
    }
}