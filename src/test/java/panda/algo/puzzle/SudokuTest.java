package panda.algo.puzzle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import panda.algo.puzzle.Sudoku;

@RunWith(value = Parameterized.class)
public class SudokuTest {
	@Parameters(name="{index}: {0}")
	public static Collection<Object[]> testResultPairs() throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		URL fileUrl = SudokuTest.class.getResource("sudoku");
		File dir = new File(fileUrl.getFile());
		File[] dirEntries = dir.listFiles();

		for (int i = 0; i < dirEntries.length; i++) {
			File dirEntry = dirEntries[i];
			String fileName = dirEntry.getName();
			if (fileName.endsWith(".txt")) {
				String testName = fileName.substring(0, fileName.lastIndexOf('.'));
				list.add(new Object[] { testName });
			}
		}

		return list;
	}

	String name;

	public SudokuTest(String testName) {
		name = testName;
	}

	private String read(String name) throws IOException {
		InputStream is = getClass().getResourceAsStream("sudoku/" + name);
		if (is == null) {
			return null;
		}

		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append('\n');
			}
			return sb.toString();
		}
		finally {
			is.close();
		}
	}

	@Test
	public void runTest() throws IOException {
		String test = read(name + ".txt");
		String expect = read(name + ".exp");
		
		String actual = solve(test);

		Assert.assertEquals(expect, actual);
	}

	private int[][] parseProblem(String text) {
		int[][] matrix = new int[9][9];
		int n = 0;
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			if (c == ' ' || c >= '0' && c <= '9') {
				if (c > '0') {
					matrix[n / 9][n % 9] = c - '0';
				}
				n++;
				if (n > 80) {
					break;
				}
			}
		}
		return matrix;
	}

	public String solve(String text) {
		int[][] matrix = parseProblem(text);
		Sudoku sudoku = new Sudoku(matrix);
		if (!sudoku.solve()) {
			return null;
		}
		
		return buildMatrix(matrix);
	}
	
	@SuppressWarnings("unused")
	private String prettyMatrix(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; ++i) {
			if (i % 3 == 0) {
				sb.append(" -----------------------\n");
			}
			for (int j = 0; j < 9; ++j) {
				if (j % 3 == 0) {
					sb.append("| ");
				}
				sb.append(matrix[i][j] == 0 ? " " : Integer.toString(matrix[i][j]));
				sb.append(' ');
			}
			sb.append("|\n");
		}
		sb.append(" -----------------------\n");
		return sb.toString();
	}

	private String buildMatrix(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(matrix[i][j] == 0 ? ' ' : (char)(matrix[i][j] + '0'));
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
