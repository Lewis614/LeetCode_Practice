package medium054.spiralMatrix;

/**
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 */

import java.util.*;

public class Solution {
	public List<Integer> sprialOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res; 
		int row = matrix.length;
		int col = matrix[0].length;
		
		int min = Math.min(row,col);
		int circleNum = min/2;
		
		for(int curCir = 0 ; curCir<circleNum; curCir++) {
			for(int j = curCir; j <col-1-curCir ; j++) {
				res.add(matrix[curCir][j]);
			}
			for(int i = curCir ;  i< row-1-curCir ; i++){
				res.add(matrix[i][col-1-curCir]);
			}
			for(int j = col-1-curCir; j>curCir; j--) {
				res.add(matrix[row-1-curCir][j]);
			}
			for(int i = row-1-curCir ; i>curCir ; i--) {
				res.add(matrix[i][curCir]);
			}
		}
		
		// handle the last odd col / row.
		if(min%2 == 1) {
			if (min == row) {
				for(int j = circleNum; j < col-circleNum ; j++) {
					res.add(matrix[row/2][j]);
				}
			}
			// either col or row, can not be both if. Watch out the details!
			else if(min == col) {
				for(int i = circleNum; i< row-circleNum ; i++) {
					res.add(matrix[i][col/2]);
				}
			}
		}
		return res;
		
	}
}
