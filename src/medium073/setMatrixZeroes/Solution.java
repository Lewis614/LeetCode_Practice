package medium073.setMatrixZeroes;
/**
 * 
 * 20150120 18:00 finish!
 * @author liuyisi
 *
 */

public class Solution {
	// Best Solution : In space O(1)
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return;
		int row = matrix.length;
		int col = matrix[0].length;

		boolean rowFlag = false;
		boolean colFlag = false;

		for(int i = 0 ; i < row ; i++) {
			if(matrix[i][0] == 0) {
				colFlag = true; 
				break;
			}
		}
		for(int j = 0 ; j< col ; j++) {
			if(matrix[0][j] == 0) {
				rowFlag = true;
				break;
			}
		}
		for(int i = 1; i<row ; i++) {
			for(int j = 1 ; j<col ; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		//More precise and easier way:
		for(int i = 1 ; i<row ; i++) {
			for(int j = 1 ; j < col ; j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j] = 0;
			}
		}
		
		/*
		for(int i = 1 ; i < row ; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 0 ; j<col; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for(int j = 1; j<col ; j++) {
			if(matrix [0][j] == 0) {
				for(int i = 0; i <row ; i++){
					matrix[i][j]=0;
				}
			}
		}
		*/
		if(rowFlag) {
			for(int j = 0; j<col; j++) {
				matrix[0][j] =0;
			}
		}
		if(colFlag) {
			for(int i = 0; i<row ; i++){
				matrix[i][0] = 0;
			}	
		}
	}

	// solution : space O(m+n)
	public void setZeroes1(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length==0) return;
		int row = matrix.length;
		int col = matrix[0].length;

		boolean[] isZeroRow = new boolean[row];
		boolean[] isZeroCol = new boolean[col];

		for(int i = 0; i<row ; i++) {
			for(int j = 0 ; j<col ; j++) {
				if(matrix[i][j] == 0) {
					isZeroRow[i] = true;
					isZeroCol[j] = true;
				}
			}
		}
		for(int i = 0; i<row ; i++) {
			for(int j = 0 ; j<col ; j++) {
				if(isZeroRow[i] && isZeroCol[j]) {
					for(int p = 0 ; p< row ; p++) {
						matrix[p][j] = 0;
					}
					for(int q = 0 ; q< col ; q++) {
						matrix[i][q] = 0;
					}
				}
			}
		}

	}
	// basic solution: space O(m*n), bad idea.
	public void setZeroes2(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length==0) return;
		int row = matrix.length;
		int col = matrix[0].length;

		boolean[][] isZero = new boolean[row][col];
		for(int i = 0; i<row ; i++) {
			for(int j = 0 ; j<col ; j++) {
				if(matrix[i][j] == 0) isZero[i][j] = true;
			}
		}
		for(int i = 0; i<row ; i++) {
			for(int j = 0 ; j<col ; j++) {
				if(isZero[i][j]) {
					for(int p = 0 ; p< row ; p++) {
						matrix[p][j] = 0;
					}
					for(int q = 0 ; q< col ; q++) {
						matrix[i][q] = 0;
					}
				}
			}
		}
	}
}
