package panda.algo.iter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import panda.lang.mutable.MutableLong;


public class PermutaterTest {
	public void permuTest(int n) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			l.add(String.valueOf(i));
		}

		MutableLong mi = new MutableLong();
		Permutater<String> p = new Permutater<String>(l);
		IterHandler<String> ih = new IterHandler<String>() {
			@Override
			public boolean handle(List<String> a) {
				mi.increment();
//				System.out.println(mi + ": " + Strings.join(a, " "));
				return true;
			}
		};

		for (int m = 1; m <= n; m++) {
			mi.setValue(0);;
//			System.out.println("------ n: " + n + " ---------- m: " + m);
			p.permutate(ih, m);
			Assert.assertEquals(p.count(m), mi.longValue());
		}
	}

	@Test
	public void test5() {
		permuTest(5);
	}
}
