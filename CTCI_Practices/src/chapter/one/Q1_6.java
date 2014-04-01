package chapter.one;

/**
 * Given an image represented by N*N matrix where each pixel in the images is 4 bytes, write a method
 * to rotate the image by 90 degrees, can you do this in place?
 * @author jerry
 *
 */

public class Q1_6 {
	public static int[][] rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				//temp = top[i]
				int temp = matrix[first][i];
				
				//top[i] = left[i]
				matrix[first][i] = matrix[n-i-1][first];
				
				//left[i] = bottom[i]
				matrix[n-i-1][first] = matrix[last][n-i-1];
				
				//bottom[i] = right[i]
				matrix[last][n-i-1] = matrix[i][last];
				
				//right[i] = temp
				matrix[i][last] = temp;
			}
		}
		return matrix;
	}
	
	//Tester
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] m2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		matrix = rotate(m2, m2.length);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
