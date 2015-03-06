package medium063.uniquePathsII;
/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * @author liuyisi
 *
 */

public class Solution {
	public int uniquePathWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0|| obstacleGrid[0].length==0) return 0;

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[] res = new int[col];
		if (obstacleGrid[0][0] == 1) return 0;
		res[0] = 1;
		for(int i = 0; i<row ; i++){
			if(obstacleGrid[i][0] == 1) res[0] = 0;
			for(int j = 1; j<col; j++){
				if(obstacleGrid[i][j] == 1) res[j] = 0;
				else res[j] +=res[j-1];	
			}				
		}
		return res[col-1];
	}
}
