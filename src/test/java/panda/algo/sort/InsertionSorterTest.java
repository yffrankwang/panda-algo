package panda.algo.sort;

import org.junit.Test;

/**
 */
public class InsertionSorterTest extends SorterTest {
	@Test
	public void testRandom() {
		InsertionSorter<Integer> s = new InsertionSorter<Integer>();
		for (int i = 1; i < 100; i++) {
			randomTest(s, i);
		}
	}
}
