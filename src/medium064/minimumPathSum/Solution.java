/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

package medium064.minimumPathSum;


public class Solution {

	// watch out for the sequence of the row and column.
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		// two dimensional DP need 2-1 dimensional array to track the result. 
		int[] res = new int[grid[0].length]; 
		res[0] = grid[0][0];
		// Two steps: remember! First to track the first line and then recursively compare the cell line by line
		//Step1
		for (int j = 1 ; j<grid[0].length ; j++) res[j] = res[j-1] + grid[0][j];
		//Step2:
		for(int i = 1; i<grid.length; i++) {
			for(int j = 0 ; j<grid[0].length ; j++) {
				if(j == 0) res[j] = res[j]+grid[i][j];
				else res[j] = Math.min(res[j-1], res[j]) + grid[i][j]; 
			}
		}
		return res[grid[0].length-1];
	}

	//column by column.
	public int minPathSum2(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

		int[] res = new int[grid.length];
		res[0] = grid[0][0];
		for(int i = 1; i < grid.length ; i++) res[i] = res[i-1]+grid[i][0];


		for(int j = 1 ; j<grid[0].length ; j++) {
			for(int i = 0; i<grid.length ; i++) {	
				if (i == 0) res[i] = res[i]+ grid[i][j];
				else res[i] = Math.min(res[i],res[i-1]) + grid[i][j];
			}
		}
		return res[grid.length-1];
	}
}