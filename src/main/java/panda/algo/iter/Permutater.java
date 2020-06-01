package panda.algo.iter;

import java.util.ArrayList;
import java.util.List;

import panda.lang.Collections;

/**
 * 
 *
 */
public class Permutater<T> {
	private List<T> org;
	private List<T> gen;
	private IterHandler<T> ith;

	/**
	 * @param list original list
	 * @param handler iteration handler
	 */
	public Permutater(List<T> list, IterHandler<T> handler) {
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
	 * @return P(n, m)
	 */
	public long count(int m) {
		return count(org.size(), m);
	}

	/**
	 * @return P(n, m)
	 */
	public static long count(int n, int m) {
		if (m < 1) {
			return 0;
		}
		
		m = (m >= n ? 2 : n - m + 1);

		long count = 1;
		for (int i = n; i >= m; i--) {
			count *= i;
		}
		return count;
	}

	public void permutate() {
		permutate(org.size());
	}

	public void permutate(int m) {
		Combinater<T> com = new Combinater<T>(org, new CombHandler());
		com.combinate(m);
	}

	private class CombHandler implements IterHandler<T> {
		@Override
		public boolean handle(List<T> list) {
			gen = new ArrayList<T>(list);
			return swap(0, gen.size());
		}
	}

	public void swap() {
		gen = new ArrayList<T>(org);
		swap(0, gen.size());
	}
	
	private boolean swap(int m, int n) {
		if (m < n - 1) {
			if (!swap(m + 1, n)) {
				return false;
			}

			for (int i = m + 1; i < n; i++) {
				Collections.swap(gen, m, i);

				if (!swap(m + 1, n)) {
					return false;
				}

				Collections.swap(gen, m, i);
			}
			return true;
		} 
		return ith.handle(gen);
	}
}
