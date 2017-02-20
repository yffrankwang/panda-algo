package panda.algorithm.sort;

import java.util.List;

/**
 * 
 */
public class BubbleSorter extends Sorter {
	public void sort(List<?> list, int from, int to) {
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
