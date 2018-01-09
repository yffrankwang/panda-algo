package panda.algorithm;

import java.util.Arrays;

/**
 * 
 *
 */
public class Combinater {
	private int n;
	private int m;
	private int[] array;
	private long count;

	/**
	 * @param n combination number
	 * @param m array size
	 */
	public Combinater(int n, int m) {
		this.n = n;
		this.m = m;
		array = new int[m];
	}
	
	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	protected boolean handle() {
		System.out.println(count + ": " + Arrays.toString(array));
		return true;
	}

	/**
	 * C(n, m)
	 * @return count
	 */
	public long count() {
		long count = 1;
		for (int i = m + 1; i <= n; i++) {
			count *= i;
		}
		for (int i = 2; i <= (n - m); i++) {
			count /= i;
		}
		return count;
	}
	
	/**
	 * C(n, m)
	 * @return combinate count
	 */
	public long combinate() {
		count = 0;
		_combinate(n, m);
		return count;
	}

	protected boolean _combinate(int n, int m) { 
		for (int i = n; i >= m; i--) {
			array[m - 1] = i - 1;
			if (m > 1) {
				if (!_combinate(i - 1, m - 1)) {
					return false;
				}
			} 
			else {
				count++;
				if (!handle()) {
					return false;
				}
			}
		}
		return true;
	} 
}
