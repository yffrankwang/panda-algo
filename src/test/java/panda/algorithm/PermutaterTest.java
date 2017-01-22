package panda.algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 */
@RunWith(value = Parameterized.class)
public class PermutaterTest {
	@Parameters(name="{0}")
	public static Collection<Object[]> createTestCase() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 10; i++) {
			list.add(new Object[] { i });
		}

		return list;
	}

	private int num;
	
	public PermutaterTest(int num) {
		this.num = num;
	}

	@Test
	public void test() {
		Permutater p = new Permutater(num);
		p.permutate();
		Assert.assertEquals(p.count(), p.getCount());
	}
}
