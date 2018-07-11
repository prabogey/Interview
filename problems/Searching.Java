public class Searching {
    // Searching 2D Matrix in which all rows are sorted and all columns are sorted
    public boolean nLogN(int[][] matrix, int target) {
        int width = matrix.length;
        if (width == 0) return false;
        int height = matrix[0].length;
        if (height == 0) return false;
        boolean possible;
        for (int i = 0; i < width; i++) {
            if (target < matrix[i][0]) {
                return false;
            }
            if (target >= matrix[i][0] && target <= matrix[i][height - 1]) {
                possible = binarySearch(matrix[i], target);
                if (possible) return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] arr, int target) {
        int middle = arr.length/2;
        if (target > arr[middle]) {
            return binarySearchHelper(arr, middle + 1, arr.length, target);
        } else if (target < arr[middle] ) {
            return binarySearchHelper(arr, 0, middle, target);
        } else {
            return true;
        }
    }
    
    private boolean binarySearchHelper(int[] arr, int start, int end, int target) {
        if (end - start == 0) {
            if (arr[start] == target) {
                return true;
            } else {
                return false;
            }
        }
        int middle = (start + (end)) /2;
        if (target > arr[middle]) {
            return binarySearchHelper(arr, middle + 1, end, target);
        } else if (target < arr[middle] ) {
            return binarySearchHelper(arr, start, middle, target);
        } else {
            return true;
        }
    }

    // if the 2D array has each row sorted and each column sorted, you can use this method to find something
    // it is O(n + m) compared to O(n log n) as the method above
    public static boolean nPlusM(int[][] arr, int target) {
        // start in top right corner
        // if the target is bigger than the value then you can move down to the next row
        // if the target is smaller than the value then you can move to the left one column space
        int i = 0;
        int j = arr[0].length - 1;
        while (j >= 0 && i < arr.length) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                col--;
            } else if (arr[i][j] < target) {
                row++;
            }
        }
        return false;
    }

    // Searching 2D Matrix in which all rows are sorted and all columns are sorted
    public static int returnOccurrence(int[][] arr, int target) {
        // return the occurences of target in the array
        int i = 0;
        int j = arr[0].length - 1;
        int count = 0;
        while (j >= 0 && i < arr.length) {
            if (arr[i][j] == target) {
                count++;
                row++;
            } else if (arr[i][j] > target) {
                col--;
            } else if (arr[i][j] < target) {
                row++;
            }
        }
        return count;
    }
}