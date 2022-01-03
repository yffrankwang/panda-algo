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
		if (n < 1 || m < 1 || n < m) {
			return 0;
		}
		
		long count = 1;

		int k = n - m;
		if (k < m) {
			k = m;
		}

		for (int i = n; i > k; i--) {
			count = count * i / (n - i + 1);
			
		}
		return count;
	}

	/**
	 * C(n, m)
	 */
	public void combinate(int m) {
		int n = org.size();
		
		if (n < 1 || m < 1 || n < m) {
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
