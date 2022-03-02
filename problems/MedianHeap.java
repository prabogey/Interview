
public class MedianHeap {
    // a median heap is a heap that keep tracks of the median
    // its left side is a max heap
    // its right side is a min heap
    // when you add the first element add to the min heap
    // if the next element is bigger then add to max heap
    // else remove from min heap and then add to max heap
    // if the heaps differ in size by 1, the median is the top of the bigger one
    // else its the average of the tops of both
    int size = 0;
    int median = 0;
    private Heap minHeap = new Heap(10, true);
    private Heap maxHeap = new Heap(10, false);

    public void medianHeap(int x) {
        if (size == 0) {
            maxHeap.add(x);
            this.median = x;
            return;
        }
        if (x > median) minHeap.add(x);
        else maxHeap.add(x);

        // min heap is larger than 1 + maxHeap
        if (minHeap.size > maxHeap.size + 1) {
            int x = minHeap.remove();
            maxHeap.add(x);
        } else if (maxHeap.size > minHeap.size + 1) { // maxHeap is larger so remove one and then add to minHeap
            int x = maxHeap.remove();
            minHeap.add(x);
        }

        // calculate median here
        if (maxHeap.size > minHeap.size) {
            median = maxHeap.poll();
            return;
        }
        if (minHeap.size > maxHeap.size) {
            median = minHeap.poll();
            return;
        }
        median = (minHeap.poll() + maxHeap.poll()) / 2;
    }
}