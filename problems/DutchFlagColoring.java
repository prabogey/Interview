public class DutchFlagColoring {
    public static void sortArr(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                mid++;
                start++;
            } else if (arr[mid] == 2) {
                int temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,0,0};
        sortArr(arr);
        for (int x: arr) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }
}