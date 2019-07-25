public class MergeSort {
	public static void merge(int[] arr) {
		merge(arr, 0, arr.length-1);
	}

	public static void merge(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + (high - 1)) / 2;
			merge(arr, low, mid);
			merge(arr, mid + 1, high);

			sort(arr, low, mid, high);
		}
	}

	public static void sort(int[] arr, int low, int mid, int high) {
		// everything left of mid is sorted
		// everything right of mid is sorted
		int l = mid - low + 1;
		int r = high - mid;

		int[] left = new int[l];
		int[] right = new int[r];

		for (int i = 0; i < l; i++) {
			left[i] = arr[low + i];
		}

		for (int i = 0; i < r; i++) {
			System.out.println(i);
			right[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = low;
		while (i < l && j < r) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
			System.out.println(k);
		}

		while (i < l) {
			arr[k] = left[i];
			k++;
			i++;
		}

		while (j < r) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}

	public static void main(String[] args) {
		int[] x = {10, 30, 20, 90, 50, 40, 80, 70};
		merge(x);
		for (int y : x) {
			System.out.println(y);
		}
	}
}