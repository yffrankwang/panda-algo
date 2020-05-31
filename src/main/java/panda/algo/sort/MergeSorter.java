package panda.algo.sort;

import java.util.ArrayList;
import java.util.List;


/**
 * compare times:  	nlog2(n)/2 ~ nlog2(n)-n+1
 */
public class MergeSorter<T> extends Sorter<T> {
	/**
	 * Tuning parameter: list size at or below which insertion sort will be used in preference to
	 * mergesort or quicksort.
	 */
	private static final int INSERTIONSORT_THRESHOLD = 7;

	public void sort(List<T> list, int from, int to) {
		List<T> src = new ArrayList<T>(list);
		mergeSort(src, list, from, to, -from);
	}

	/**
	 * Src is the source array that starts at index 0 Des is the (possibly larger) array
	 * destination with a possible offset low is the index in des to start sorting high is the end
	 * index in des to end sorting off is the offset into src corresponding to low in des
	 */
	private void mergeSort(List<T> src, List<T> des, int low, int high, int off) {
		int length = high - low;

		// Insertion sort on smallest arrays
		if (length < INSERTIONSORT_THRESHOLD) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low && compare(des, j - 1, j) > 0; j--)
					swap(des, j, j - 1);
			return;
		}

		// Recursively sort halves of des into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(des, src, low, mid, -off);
		mergeSort(des, src, mid, high, -off);

		// If list is already sorted, just copy from src to des. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (compare(src, mid - 1, mid) <= 0) {
			copy(src, low, des, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into des
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && compare(src, p, q) <= 0)
				des.set(i, src.get(p++));
			else
				des.set(i, src.get(q++));
		}
	}
}
