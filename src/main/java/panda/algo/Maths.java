package panda.algo;

public class Maths {
	public static int maxDivisor(int x, int y) {
		if (x == y) {
			return x;
		}
		if (x > y) {
			int t = x;
			x = y;
			y = t;
		}
		if (x < 2) {
			return 1;
		}
		
		int r = 1;
		int i = Math.min(x, y >> 1);
		while (true) {
			if (i < 2) {
				break;
			}
			if (x % i == 0 && y % i == 0) {
				x /= i;
				y /= i;
				r *= i;
				i = Math.min(x, y >> 1);
			}
			else {
				i--;
			}
		}
		
		return r;
	}
}
