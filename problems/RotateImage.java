public class RotateImage {
    // first reverse the image on its horizontal axis
    // ie last row becomes first row
    // the swap values on digaonals
    public void rotateImage(int[][] arr) {
        if (arr == null) return;
        int rows = arr.length;
        int cols = arr[0].length;
        int first = 0;
        int last = cols - 1;
        while (last > first) {
            int[] temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            last--;
            first++;
        }
        // now the matrix has been reflected on its horizontal axis

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}