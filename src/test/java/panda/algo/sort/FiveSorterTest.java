package panda.algo.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import panda.algo.iter.IterHandler;
import panda.algo.iter.Permutater;
import panda.lang.Strings;
import panda.lang.mutable.MutableInt;

/**
 */
public class FiveSorterTest {
	protected void sortAndVerify(int c, Sorter<Integer> s, List<Integer> a) {
		System.out.println("-------- " + c + " ---------");
		System.out.println(Strings.join(a, ", "));

		s.sort(a);
		
		System.out.println(Strings.join(a, ", "));

		Assert.assertTrue(s.verify(a));
	}

	@Test
	public void test() {
		int n = 5;

		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			l.add(Integer.valueOf(i));
		}

		MutableInt mi = new MutableInt();
		FiveSorter<Integer> s = new FiveSorter<Integer>();
		Permutater<Integer> p = new Permutater<Integer>(l);
		IterHandler<Integer> ih = new IterHandler<Integer>() {
			@Override
			public boolean handle(List<Integer> list) {
				mi.increment();
				List<Integer> a = new ArrayList<Integer>(list);
				sortAndVerify(mi.intValue(), s, a);
				return true;
			}
		};

		p.permutate(ih);
	}
}
