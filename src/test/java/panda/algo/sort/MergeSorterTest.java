package panda.algo.sort;

import org.junit.Test;

/**
 */
public class MergeSorterTest extends SorterTest {
	@Test
	public void testRandom() {
		MergeSorter<Integer> s = new MergeSorter<Integer>();
		for (int i = 1; i < 100; i++) {
			randomTest(s, i);
		}
	}
}
