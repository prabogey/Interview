import java.util.*;

public class RectangleProblem {
    public static void main(String[] args) {
        int[][] multi = new int[][]{
            { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 }
          };
        ArrayList<ArrayList<Integer>> vals = rectangleFinder(multi);
        for (ArrayList<Integer> i: vals) {
            for (Integer x: i) {
                System.out.println(x);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> rectangleFinder(int[][] arr) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 1) {
                    if (i == 0 && j == 0) { // (0,0) is 1
                        rectChecker(arr, i, j, ret);
                    } else if (i != 0 && j == 0 && arr[i - 1][j] == 0) { //something on the left edge is 1
                        rectChecker(arr, i, j, ret);
                    } else if (i == 0 && j != 0 && arr[i][j - 1] == 0) { //something on the top edge is 1
                        rectChecker(arr, i, j, ret);
                    } else if (i != 0 && j != 0 && arr[i - 1][j] == 0 && arr[i][j - 1] == 0) { //something in the middle is 1
                        rectChecker(arr, i, j, ret);
                    }
                }
            }
        }
        return ret;
    }

    private static void rectChecker(int[][] arr, int x, int y, ArrayList<ArrayList<Integer>> ret) {
        int height = 0;
        int width = 0;
        for (int i = x + 1; i < arr.length; i++) {
            if (arr[i][y] == 1) {
                width++;
            }
        }
        for (int i = y + 1; i < arr[0].length; i++) {
            if (arr[x][i] == 1) {
                height++;
            }
        }
        ArrayList<Integer> app = new ArrayList<>();
        app.add(x);
        app.add(y);
        app.add(x + width);
        app.add(y + height);
        ret.add(app);
    }
}