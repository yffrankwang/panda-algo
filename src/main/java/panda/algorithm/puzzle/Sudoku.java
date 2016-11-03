package panda.algorithm.puzzle;


/**
 * The <code>Sudoku</code> class povides a static <code>main</code>
 * method allowing it to be called from the command line to print the
 * solution to a specified Sudoku problem.
 *
 * <p>The following is an example of a Sudoku problem:
 *
 * <pre>
 * -----------------------
 * |   8   | 4   2 |   6   |
 * |   3 4 |       | 9 1   |
 * | 9 6   |       |   8 4 |
 *  -----------------------
 * |       | 2 1 6 |       |
 * |       |       |       |
 * |       | 3 5 7 |       |
 *  -----------------------
 * | 8 4   |       |   7 5 |
 * |   2 6 |       | 1 3   |
 * |   9   | 7   1 |   4   |
 *  -----------------------
 * </pre>
 *
 * The goal is to fill in the missing numbers so that
 * every row, column and box contains each of the numbers
 * <code>1-9</code>.  Here is the solution to the
 * problem above:
 *
 * <pre>
 *  -----------------------
 * | 1 8 7 | 4 9 2 | 5 6 3 |
 * | 5 3 4 | 6 7 8 | 9 1 2 |
 * | 9 6 2 | 1 3 5 | 7 8 4 |
 *  -----------------------
 * | 4 5 8 | 2 1 6 | 3 9 7 |
 * | 2 7 3 | 8 4 9 | 6 5 1 |
 * | 6 1 9 | 3 5 7 | 4 2 8 |
 *  -----------------------
 * | 8 4 1 | 9 6 3 | 2 7 5 |
 * | 7 2 6 | 5 8 4 | 1 3 9 |
 * | 3 9 5 | 7 2 1 | 8 4 6 |
 *  -----------------------
 * </pre>
 *
 * Note that the first row <code>187492563</code> contains
 * each number exactly once, as does the first column
 * <code>159426873</code>, the upper-left box
 * <code>187534962</code>, and every other row, column
 * and box.
 *
 * <p>See <a href="http://en.wikipedia.org/wiki/Sudoku">Wikipedia:
 * Sudoku</a> for more information on Sudoku.
 *
 * <p>The algorithm employed is similar to the standard backtracking
 * <a href="http://en.wikipedia.org/wiki/Eight_queens_puzzle">eight
 * queens algorithm</a>.
 *
 */
public class Sudoku {
	private int[][] cells;
	
	public Sudoku(int[][] cells) {
		this.cells = cells;
	}
	
	public boolean solve() {
		return solve(0, 0);
	}
	
	private boolean solve(int i, int j) {
		if (i == 9) {
			i = 0;
			if (++j == 9) {
				return true;
			}
		}
		if (cells[i][j] != 0) {
			// skip filled cells
			return solve(i + 1, j);
		}

		for (int val = 1; val <= 9; ++val) {
			if (legal(i, j, val)) {
				cells[i][j] = val;
				if (solve(i + 1, j)) {
					return true;
				}
			}
		}
		cells[i][j] = 0; // reset on backtrack
		return false;
	}

	private boolean legal(int i, int j, int val) {
		for (int k = 0; k < 9; ++k) {
			// row
			if (val == cells[k][j]) {
				return false;
			}
		}

		for (int k = 0; k < 9; ++k) {
			// col
			if (val == cells[i][k]) {
				return false;
			}
		}
		
		int boxRowOffset = (i / 3) * 3;
		int boxColOffset = (j / 3) * 3;
		for (int k = 0; k < 3; ++k) {
			// box
			for (int m = 0; m < 3; ++m) {
				if (val == cells[boxRowOffset + k][boxColOffset + m]) {
					return false;
				}
			}
		}

		return true; // no violations, so it's legal
	}
}
