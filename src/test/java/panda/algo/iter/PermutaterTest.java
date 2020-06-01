package panda.algo.iter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import panda.lang.Strings;
import panda.lang.mutable.MutableLong;


public class PermutaterTest {
	public void permuTest(int n) {
		List<String> a = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			a.add(String.valueOf(i));
		}

		Set<List<String>> ss = new HashSet<List<String>>();
		MutableLong mi = new MutableLong();
		IterHandler<String> h = new IterHandler<String>() {
			@Override
			public boolean handle(List<String> a) {
				mi.increment();
				System.out.println(mi + ": " + Strings.join(a, " "));
				Assert.assertFalse(ss.contains(a));
				ss.add(a);
				return true;
			}
		};
		Permutater<String> p = new Permutater<String>(a, h);

		for (int m = 1; m <= n; m++) {
			System.out.println("------ n: " + n + " ---------- m: " + m);
			ss.clear();
			mi.setValue(0);;
			p.permutate(m);
			Assert.assertEquals(p.count(m), mi.longValue());
		}
	}

	@Test
	public void test5() {
		permuTest(5);
	}
}
