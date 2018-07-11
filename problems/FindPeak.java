public class FindPeak {
    public static int peak(int[] arr) {
        // write your code here
        int middle = arr.length/2;
        if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
            return middle;
        }
        if (arr[middle] < arr[middle - 1]) {
            return binarySearch(arr, 0, middle);
        } else {
            return binarySearch(arr, middle, arr.length - 1);
        }
    }
        
    public static int binarySearch(int[] arr, int start, int end) {
        int middle = (end-start) / 2;
        if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
            return middle;
        }
        if (arr[middle] < arr[middle - 1]) {
            return binarySearch(arr, start, middle);
        } else {
            return binarySearch(arr, middle, end);
        }
    }

    public static void main(String[] args) {
        int[] arg = {1,2,1,3,4,5,7,6};
        System.out.println(peak(arg));
    }
}