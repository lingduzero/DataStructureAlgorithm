package com.laioffer.section15.DPThree;

public class LongestCrossOfOne {
	public int largest(int[][] matrix) {
		// Write your solution here.

		int row = matrix.length;
	
		if (matrix == null || row == 0) {
			return 0;
		}
		int column = matrix[0].length;
		if (column == 0) {
			return 0;
		}
		int[][] leftUp = leftUp(matrix, row, column);
		int[][] rightDown = rightDown(matrix, row, column);
		
		return merge(leftUp, rightDown, row, column);
	}

	private int[][] leftUp(int[][] matrix, int row, int column) {
		// Create the in[][] matrix from up to bottom and left to right
		int[][] up = new int[row][column];
		int[][] left = new int[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 && j == 0) {
						up[i][j] = 1;
						left[i][j] = 1;
					} else if (i == 0) {
						up[i][j] = 1;
						left[i][j] = left[i][j - 1] + 1;
					} else if (j == 0) {
						left[i][j] = 1;
						up[i][j] = up[i - 1][j] + 1;
					} else {
						up[i][j] = up[i - 1][j] + 1;
						left[i][j] = left[i][j - 1] + 1;
					}
				}
			}
		}

		merge(left, up, row, column);
		return left;
	}
	
	private int[][] rightDown(int[][] matrix, int row, int column) {
		// Create the in[][] matrix from up to bottom and left to right
		int[][] down = new int[row][column];
		int[][] right = new int[row][column];

		for (int i = row - 1; i >= 0; i--) {
			for (int j = column - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == row - 1 && j == column - 1) {
						down[i][j] = 1;
						right[i][j] = 1;
					} else if (i == row - 1) {
						down[i][j] = 1;
						right[i][j] = right[i][j + 1] + 1;
					} else if (j == column - 1) {
						right[i][j] = 1;
						down[i][j] = down[i + 1][j] + 1;
					} else {
						down[i][j] = down[i + 1][j] + 1;
						right[i][j] = right[i][j + 1] + 1;
					}
				}
			}
		}

		merge(right, down, row, column);
		return right;
	}

	private int merge(int[][] leftUp, int[][] rightDown, int row, int column) {
		int result = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
				result = Math.max(result, leftUp[i][j]);
			}
		}
		return result;
	}

}
