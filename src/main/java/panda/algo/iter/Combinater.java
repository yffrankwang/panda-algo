package panda.algo.iter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Combinater<T> {
	private List<T> org;
	private List<T> gen;

	/**
	 * @param list original list
	 */
	public Combinater(List<T> list) {
		org = list;
	}

	/**
	 * C(n, m)
	 * @return count
	 */
	public long count(int m) {
		int n = org.size();
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
	 */
	public void combinate(IterHandler<T> ih, int m) {
		gen = new ArrayList<T>(m);
		for (int i = 0; i < m; i++) {
			gen.add(null);
		}
		combinate(ih, org.size(), m);
	}

	protected boolean combinate(IterHandler<T> ih, int n, int m) { 
		for (int i = n; i >= m; i--) {
			gen.set(m - 1, org.get(i - 1));
			if (m > 1) {
				if (!combinate(ih, i - 1, m - 1)) {
					return false;
				}
			} 
			else {
				if (!ih.handle(gen)) {
					return false;
				}
			}
		}
		return true;
	} 
}
