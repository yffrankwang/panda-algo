package panda.algo.sort;

import java.util.List;


/**
 * sort only five elements
 * https://strangerxxx.hateblo.jp/entry/20200221/1582289855
 * 
 * N=5のときの比較方法

まず2個を選んで比較、残りから2個を選んで比較します。またそのうち軽い方同士を比較し、軽かったほうの組を軽い順に(a, b)、重い組を(c, d)とし、比較してないものをeとします。

ここまででa<bかつa<c<dということがわかります。

次にcとeを比較します。この結果によって分岐します。
 c<eのとき

次に d,eを比較します。eのほうが軽いとき、d,eを入れ替えます。するとa<bかつa<c<d<eとなります。よってbをdと比較→cかeと比較、と二分探索風にすることで、7回の比較で順番がすべてわかります。
 e<cのとき

こっちは少し面倒です。まずa,eを比較します。a<eのとき、b,cを比較します。

bが軽ければa<b<c<dかつa<e<c<dとなるので、b,eを比較すればよいです。

またcが軽ければa<e<c<dかつa<e<c<bとなるのでbとdを比較すればよいです。

e<aのときはb,cを比較します。

bが軽ければe<a<b<c<dで確定です。この場合だけ最も少ない6回の比較で済みます。

またcが軽ければe<a<c<bかつe<a<c<dとなるのでbとdを比較すればよいです。
 */
public class FiveSorter<T> extends Sorter<T> {
	public void sort(List<T> list, int from, int to) {
		if (compare(list, 0, 1) > 0) {
			swap(list, 0, 1);
		}

		if (compare(list, 2, 3) > 0) {
			swap(list, 2, 3);
		}

		if (compare(list, 0, 2) > 0) {
			swap(list, 0, 2);
			swap(list, 1, 3);
		}

		if (compare(list, 2, 4) < 0) {
			if (compare(list, 3, 4) > 0) {
				swap(list, 3, 4);
			}

			if (compare(list, 1, 3) < 0) {
				if (compare(list, 1, 2) < 0) {
					return;
				}
				swap(list, 1, 2);
				return;
			}

			if (compare(list, 1, 4) < 0) {
				swap(list, 1, 2);
				swap(list, 2, 3);
				return;
			}

			swap(list, 1, 2);
			swap(list, 2, 3);
			swap(list, 3, 4);
			return;
		}

		if (compare(list, 0, 4) < 0) {
			if (compare(list, 1, 2) < 0) {
				if (compare(list, 1, 4) < 0) {
					swap(list, 3, 4);
					swap(list, 2, 3);
					return;
				}

				swap(list, 3, 4);
				swap(list, 2, 3);
				swap(list, 1, 2);
				return;
			}

			if (compare(list, 1, 3) < 0) {
				swap(list, 1, 4);
				swap(list, 3, 4);
				return;
			}

			swap(list, 1, 4);
			return;
		}

		if (compare(list, 1, 2) < 0) {
			swap(list, 3, 4);
			swap(list, 2, 3);
			swap(list, 1, 2);
			swap(list, 0, 1);
			return;
		}

		if (compare(list, 1, 3) < 0) {
			swap(list, 3, 4);
			swap(list, 1, 3);
			swap(list, 0, 1);
			return;
		}
		swap(list, 1, 4);
		swap(list, 0, 1);
	}
}
