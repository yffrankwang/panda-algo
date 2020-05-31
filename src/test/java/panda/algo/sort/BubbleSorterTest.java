package panda.algo.sort;

import org.junit.Test;

/**
 */
public class BubbleSorterTest extends SorterTest {
	@Test
	public void testRandom() {
		BubbleSorter<Integer> bs = new BubbleSorter<Integer>();
		for (int i = 1; i < 100; i++) {
			randomTest(bs, i);
		}
	}
}
