package panda.algo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import panda.algo.Combinater;

@RunWith(value = Parameterized.class)
public class CombinaterTest {
	@Parameters(name="{0}:{1}")
	public static Collection<Object[]> createTestCase() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < i - 1; j++) {
				list.add(new Object[] { i, j });
			}
		}

		return list;
	}

	private int n;
	private int m;
	
	public CombinaterTest(int n, int m) {
		this.n = n;
		this.m = m;
	}

	@Test
	public void test() {
		Combinater c = new Combinater(n, m);
		c.combinate();
		Assert.assertEquals(c.count(), c.getCount());
	}
}

