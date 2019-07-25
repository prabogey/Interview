public class ReverseInteger {
	public static int reverse(int x) {
		int newNum = 0;
		while (x > 0) {
			int y = x % 10;
			newNum = newNum * 10 + y;
			x = x / 10
		}
		return newNum;
	}

	public static void main(String[] args) {
		System.out.println(reverse(54321));
	}
}