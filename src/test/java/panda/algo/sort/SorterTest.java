package panda.algo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;

import panda.lang.Strings;

/**
 */
public class SorterTest {
	protected void sortAndVerify(Sorter<Integer> s, List<Integer> a) {
		System.out.println("-----------------");
		System.out.println(Strings.join(a, ", "));

		s.sort(a, 1, a.size() - 1);
		
		System.out.println(Strings.join(a, ", "));

		Assert.assertTrue(s.verify(a, 1, a.size() - 1));
	}
	
	protected void randomTest(Sorter<Integer> s, int n) {
		Random r = new Random();
		
		List<Integer> a = new ArrayList<Integer>(); 
		for (int i = 0; i < n; i++) {
			a.add(r.nextInt(n));
		}

		sortAndVerify(s, a);
	}
}
