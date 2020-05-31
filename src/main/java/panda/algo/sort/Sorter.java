package panda.algo.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 
 *
 */
public abstract class Sorter<T> {
	protected Comparator<T> comparator;
	protected boolean ascend;
	
	public Sorter() {
		this(null, true);
	}
	
	public Sorter(boolean ascend) {
		this(null, ascend);
	}
	
	public Sorter(Comparator<T> comparator) {
		this(comparator, true);
	}
	
	public Sorter(Comparator<T> comparator, boolean ascend) {
		this.comparator = comparator;
		this.ascend = ascend;
	}
	
	/**
	 * @return the ascend
	 */
	public boolean isAscend() {
		return ascend;
	}

	/**
	 * @param ascend the ascend to set
	 */
	public void setAscend(boolean ascend) {
		this.ascend = ascend;
	}

	/**
	 * Sorts the list
	 * 
	 * @param list the list to be sorted
	 * @param from the index of the first element (inclusive) to be sorted
	 * @param to the index of the last element (exclusive) to be sorted
	 */
	public abstract void sort(List<T> list, int from, int to);

	/**
	 * Sorts the array
	 * 
	 * @param array the array to be sorted
	 * @param from the index of the first element (inclusive) to be sorted
	 * @param to the index of the last element (exclusive) to be sorted
	 */
	public void sort(T[] array, int from, int to) {
		sort(Arrays.asList(array), from, to);
	}

	public void sort(List<T> list) {
		sort(list, 0, list.size());
	}

	public void sort(T[] array) {
		sort(Arrays.asList(array), 0, array.length);
	}
	
	@SuppressWarnings("unchecked")
	protected int compare(T a, T b) {
		if (comparator == null) {
			return ascend ? ((Comparable)a).compareTo(b) : ((Comparable)b).compareTo(a);
		}
		return comparator.compare(a, b);
	}

	protected int compare(List<T> list, int x, int y) {
		return compare(list.get(x), list.get(y));
	}
	
	protected void swap(List<T> list, int x, int y) {
		Collections.swap(list, x, y);
	}

	protected void move(List<T> list, int x, int y) {
		list.add(y, list.remove(x));
	}

	/**
	 * @param src the source array.
	 * @param srcPos starting position in the source array.
	 * @param des the destination array.
	 * @param desPos starting position in the destination data.
	 * @param length the number of array elements to be copied.
	 */
	protected void copy(List<T> src, int srcPos, List<T> des, int desPos, int length) {
		for (int i = 0; i < length; i++) {
			des.set(desPos + i, src.get(srcPos + i));
		}
	}

	public boolean verify(List<T> list) {
		return verify(list, 0, list.size());
	}

	public boolean verify(List<T> list, int from, int to) {
		for (int i = from; i < to; i++) {
			for (int j = from; j < to; j++) {
				if (i != j) {
					int c = compare(list, i, j);
					if ((i < j && c > 0) || (i > j && c < 0)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean verify(T[] array) {
		return verify(array, 0, array.length);
	}
	
	public boolean verify(T[] array, int from, int to) {
		return verify(Arrays.asList(array), from, to);
	}
}
