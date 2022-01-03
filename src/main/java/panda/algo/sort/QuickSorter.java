package panda.algo.sort;

import java.util.List;

/**
 */
public class QuickSorter<T> extends Sorter<T> {
	public void sort(List<T> list, int from, int to) {
		qsort(list, 0, list.size() - 1);
	}

	private void qsort(List<T> list, int low, int high) {
		if (low >= high)
			return;

		int pivot = partition(list, low, high); // 将数组分为两部分
		qsort(list, low, pivot - 1); // 递归排序左子数组
		qsort(list, pivot + 1, high); // 递归排序右子数组
	}

	private int partition(List<T> list, int low, int high) {
		int org = low;
		T pivot = list.get(low); // 基准

		System.out.println("--------------------------------");
		System.out.println("L: " + low + ", H: " + high + ", P: " + pivot);

		while (low < high) {
			while (low < high && compare(list.get(high), pivot) >= 0)
				--high;
			list.set(low, list.get(high)); // 交换比基准大的记录到左端
			System.out.println("0: " + high + " -> " + low + " " + list);

			while (low < high && compare(list.get(low), pivot) <= 0)
				++low;
			list.set(high, list.get(low)); // 交换比基准小的记录到右端
			System.out.println("1: " + low + " -> " + high + " " + list);
		}

		// 扫描完成，基准到位
		list.set(low, pivot);
		System.out.println("2: " + org + " -> " + low + " " + list);

		// 返回的是基准的位置
		return low;
	}
}
