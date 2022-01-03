package panda.algo.sort;

import org.junit.Test;

/**
 */
public class QuickSorterTest extends SorterTest {
	@Test
	public void testRandom() {
		QuickSorter<Integer> bs = new QuickSorter<Integer>();
		randomTest(bs, 10);
		for (int i = 1; i < 100; i++) {
			randomTest(bs, i);
		}
	}
}
