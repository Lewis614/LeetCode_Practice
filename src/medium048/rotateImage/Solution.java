/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Could you do this in-place?
 */

package medium048.rotateImage;

public class Solution {
	/* In-space Solution. 10min solution
    1 2 3         7 8 9       7 4 1 
    4 5 6   =>    4 5 6  =>   8 5 2 
    7 8 9         1 2 3       9 6 3 
	*/  
	public void rotate3(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		int row = matrix.length;
		for(int i = 0 ; i< row/2; i++){
			for(int j = 0 ; j<row; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[row-1-i][j];
				matrix[row-1-i][j] = temp;
			}
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j <i ; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	//In-space Solution.Simple rotate.
	/**Wrong SOLUTION
	 * 
	 * @param matrix
	 */
	public void rotate2(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		int row = matrix.length;
		for(int i = 0 ; i< row/2; i++){
			for(int j = i ; j<row-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][row-1-i];
				matrix[j][row-1-i] = matrix[row-1-i][j];
				matrix[row-1-i][j] = matrix[j][row-1-i];
				matrix[j][row-1-i] = temp;
			}
		}
	}
	
	//My 20min quick solution with 3times try. because the sloppy in details.
	public void rotate1(int[][] matrix) {
		if(matrix==null) return;
		int row = matrix.length;
		
		if(row == 0) return;
		
		int[][] res = new int[row][row];
		
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<row; j++) {
				res[j][row-1-i] = matrix[i][j];
			}
		}
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<row; j++) {
				matrix[i][j]=res[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Solution s = new Solution();
		s.rotate3(test);
	}
}
