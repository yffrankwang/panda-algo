package panda.algo.sort;

import java.util.List;

/**
 * https://www.geeksforgeeks.org/insertion-sort/
 * compare times: n - 1 ~ n * (n - 1) / 2
 */
public class InsertionSorter<T> extends Sorter<T> {
	public void sort(List<T> list, int from, int to) {
		for (int i = from + 1; i < to; i++) {
			T x = list.get(i);
			int j = i - 1;

			// Move elements of list[0..i-1], 
			// that are greater than x, to one position ahead of their current position
			while (j >= from && compare(list.get(j), x) > 0) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, x);
		}
	}
}
