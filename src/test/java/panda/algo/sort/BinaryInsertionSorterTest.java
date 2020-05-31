package panda.algo.sort;

import org.junit.Test;

/**
 */
public class BinaryInsertionSorterTest extends SorterTest {
	@Test
	public void testRandom() {
		BinaryInsertionSorter<Integer> s = new BinaryInsertionSorter<Integer>();
		for (int i = 1; i < 100; i++) {
			randomTest(s, i);
		}
	}
}
