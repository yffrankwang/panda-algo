package panda.algo.sort;

import java.util.List;

/**
 * compare times: n * (n - 1) / 2
 */
public class BubbleSorter<T> extends Sorter<T> {
	public void sort(List<T> list, int from, int to) {
		boolean change = true;
		for (int i = to - 1; i > from && change; i--) {
			change = false;
			for (int j = from; j < i; j++) {
				if (compare(list, j, j + 1) > 0) {
					swap(list, j, j + 1);
					change = true;
				}
			}
		}
	}
}
