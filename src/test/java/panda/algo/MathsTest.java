package panda.algo;

import org.junit.Assert;
import org.junit.Test;

public class MathsTest {
	@Test
	public void testMaxDivisor() {
		Assert.assertEquals(6, Maths.maxDivisor(30, 42));
	}

}
