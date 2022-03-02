public class GCD
{
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int generalizedGCD(int arr[])
  {
    // INSERT YOUR CODE HERE
    if (arr.length == 1) return arr[0];
    int gcd = findGCD(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++) {
        gcd = findGCD(gcd, arr[i]);
    }
    return gcd;

  }
  // METHOD SIGNATURE ENDS
  
  private static int findGCD(int x, int y) {
      int r;
      while (y != 0) {
          r = x % y;
          x = y;
          y = r;
      }
      return x;
  }

  public static void main(String[] args) {
      System.out.println(findGCD(2, 4));
  }
}