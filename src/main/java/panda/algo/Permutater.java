package panda.algo;


/**
 * 
 *
 */
public class Permutater {
	protected int[] array;
	protected long count;
	
	public Permutater(int size) {
		array = new int[size];
	}
	
	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	protected boolean handle() {
		System.out.println(count + ": " + java.util.Arrays.toString(array));
		return true;
	}
	
	public long count() {
		long count = 1;
		for (int i = 2; i <= array.length; i++) {
			count *= i;
		}
		return count;
	}

	public long permutate() {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		count = 0;
		permutate(0, array.length);
		return count;
	}
	
	protected boolean permutate(int m, int len) {
		if (m < len - 1) {
			if (!permutate(m + 1, len)) {
				return false;
			}

			for (int i = m + 1; i < len; i++) {
				swap(array, m, i);

				if (!permutate(m + 1, len)) {
					return false;
				}

				swap(array, m, i);
			}
			return true;
		} 
		else {
			count++;
			return handle();
		}
	}

	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
