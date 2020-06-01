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
	private IterHandler<T> ith;

	/**
	 * @param list original list
	 * @param handler iteration handler
	 */
	public Combinater(List<T> list, IterHandler<T> handler) {
		org = list;
		ith = handler;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return org;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.org = list;
	}

	/**
	 * @return the handler
	 */
	public IterHandler<T> getHandler() {
		return ith;
	}

	/**
	 * @param handler the handler to set
	 */
	public void setHandler(IterHandler<T> handler) {
		this.ith = handler;
	}

	/**
	 * @return C(n, m)
	 */
	public long count(int m) {
		return count(org.size(), m);
	}
	
	/**
	 * @return C(n, m)
	 */
	public static long count(int n, int m) {
		if (m < 1) {
			return 0;
		}
		
		long count = 1;
		for (int i = m + 1; i <= n; i++) {
			count *= i;
		}
		
		int t = n - m;
		for (int i = 2; i <= t; i++) {
			count /= i;
		}
		return count;
	}

	/**
	 * C(n, m)
	 */
	public void combinate(int m) {
		if (m < 1) {
			return;
		}

		if (gen == null) {
			gen = new ArrayList<T>(m);
		}
		else {
			gen.clear();
		}
		for (int i = 0; i < m; i++) {
			gen.add(null);
		}
		combinate(org.size(), m);
	}

	protected boolean combinate(int n, int m) { 
		for (int i = n; i >= m; i--) {
			gen.set(m - 1, org.get(i - 1));
			if (m > 1) {
				if (!combinate(i - 1, m - 1)) {
					return false;
				}
			} 
			else {
				if (!ith.handle(gen)) {
					return false;
				}
			}
		}
		return true;
	} 
}
