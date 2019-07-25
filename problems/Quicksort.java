public class Quicksort {
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quicksort(arr, low, p - 1);
            quicksort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (j < high) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
		int[] x = {10, 30, 20, 90, 50, 40, 80, 70};
		quicksort(x);
		for (int y : x) {
			System.out.println(y);
		}
	}
}