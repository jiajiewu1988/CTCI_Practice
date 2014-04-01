package chapter.one;

/**
 * Write an algorithm such that if an element in MxN matrix is 0, its entire row and column is 0
 * @author jerry
 *
 */

public class Q1_7 {
	public static int[][] setZero(int[][] matrix) {
		boolean[] rowRecord = new boolean[matrix.length];
		boolean[] colRecord = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			rowRecord[i] = false;
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			colRecord[i] = false;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rowRecord[i] = true;
					colRecord[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rowRecord[i] || colRecord[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}
}
