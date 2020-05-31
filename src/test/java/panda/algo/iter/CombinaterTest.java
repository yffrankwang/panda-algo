package panda.algo.iter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import panda.lang.mutable.MutableLong;

public class CombinaterTest {
	public void combTest(int n) {
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(i);
		}

		MutableLong mi = new MutableLong();
		Combinater<Integer> c = new Combinater<Integer>(a);
		IterHandler<Integer> ih = new IterHandler<Integer>() {
			@Override
			public boolean handle(List<Integer> a) {
				mi.increment();
//				System.out.println(mi + ": " + Strings.join(a, " "));
				return true;
			}
		};

		for (int m = 1; m < n; m++) {
			mi.setValue(0);;
//			System.out.println("------ n: " + n + " ---------- m: " + m);
			c.combinate(ih, m);
			Assert.assertEquals(c.count(m), mi.longValue());
		}
	}

	@Test
	public void test5() {
		combTest(5);
	}
}

