package panda.algo.iter;

import java.util.List;

import panda.lang.Collections;

/**
 * 
 *
 */
public class Permutater<T> {
	protected List<T> list;

	public Permutater(List<T> list) {
		this.list = list;
	}

	public long count() {
		return count(list.size());
	}

	public long count(int n) {
		long count = 1;
		for (int i = 2; i <= n; i++) {
			count *= i;
		}
		return count;
	}

	public void permutate(IterHandler<T> ih) {
		permutate(ih, list.size());
	}

	public void permutate(IterHandler<T> ih, int n) {
		permutate(ih, n, 0);
	}

	protected boolean permutate(IterHandler<T> ih, int n, int m) {
		if (m < n - 1) {
			if (!permutate(ih, n, m + 1)) {
				return false;
			}

			for (int i = m + 1; i < n; i++) {
				Collections.swap(list, m, i);

				if (!permutate(ih, n, m + 1)) {
					return false;
				}

				Collections.swap(list, m, i);
			}
			return true;
		} 
		return ih.handle(list);
	}
}
