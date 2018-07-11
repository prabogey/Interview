# Misc Interview Notes

* if you have a 2D matrix, and only want to iterate once
    * m x n matrix
    * x = 0 -> m * n - 1
    * a[x] = 2D[x / m][x % m]
* Serialization of a tree
    * very important concept
    * allows you to save each intermediate subtree has its own structure
    * serialize in a string
    * Look at DuplicatesBST.java to find the code
    * essentially are linearizing the tree
* Find the peak of an array
    * every adjacent number is unique
    * Arr[0] < Arr[1] && Arr[length - 2] > Arr[length - 1]
    * use binary search
    * optain midpoint, if midpoint is greater than adjacent numbers return it
    * if midpoint is less than left neighbor, split from start to middle
    * if midpoint is less than right neighbor, split from middle to end
    * return just one index of a peak
* Copy List With Random Pointer (method)
    * Every node in this linked list has a next pointer and a random pointer which points to some random node
    * To copy this list, you cant simply just copy the random pointer, because it could point anywhere
    * First, make a copy of each node adjacent to itsself
        * Example: 1 -> 2 -> 3 -> = 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4
    * Then start from the head and set head.next.random = head.random.next;
    * iterate by saying head = head.next.next;
    * Since the random pointer of the original nodes always points to the first node (the original), and each original nodes next pointer = its copied node
    * This method will simply set the copied nodes random to the copy of its original random node pointer
* How to find the mildde of a linked list
    * have a fast and slow pointer
    * fast = fast.next.next
    * when fast.next.next or fast.next == null
    * then slow is at the middle
    * if only fast.next == null, there are an odd number of elements in the linked list
    * so then you set slow = slow.next
* Find K largest numbers in a dataset of One Billion
    * min heap
    * keep adding to heap as you iterate through array
    * if heap.size() == K
    * if the number you are at is greater than heap.peek() then remove from heap and add this number
    * else continue
    * O(N log K) better than just sorting which is O(N log N)