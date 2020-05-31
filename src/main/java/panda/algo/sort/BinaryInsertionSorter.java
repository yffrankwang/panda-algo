package panda.algo.sort;

import java.util.List;

/**
 * https://www.geeksforgeeks.org/binary-insertion-sort/
 * compare times: n - 1 ~ n * (n - 1) / 2
 */
public class BinaryInsertionSorter<T> extends Sorter<T> {
	private int binarySearch(List<T> list, int from, int to, T key) {
		int low = from;
		int high = to - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;

			T midVal = list.get(mid);

			int cmp = compare(midVal, key);

			if (cmp < 0) {
				low = mid + 1;
			}
			else if (cmp > 0) {
				high = mid - 1;
			}
			else {
				return mid; // key found
			}
		}
		return -(low + 1); // key not found.
	}

	public void sort(List<T> list, int from, int to) {
		for (int i = from + 1; i < to; i++) {
			T x = list.get(i);
			
			// find location to insert using binary search 
			int j = Math.abs(binarySearch(list, from, i, x) + 1); 

			// move the element
			move(list, i, j);
		}
	}
}
