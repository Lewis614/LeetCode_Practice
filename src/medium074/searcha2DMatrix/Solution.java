package medium074.searcha2DMatrix;
/**
 * [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
  ]
 * @author liuyisi
 *
 */

public class Solution {
	
	// Online efficient solution: two binary search.
	public boolean searchMatrix (int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length==0) return false;
		
		int up = 0;
		int down = matrix.length-1;
		
		while (up<=down) {
			int mid = (up+down)/2;
			if(matrix[mid][0]== target) return true;
			else if(target<matrix[mid][0]) down = mid-1;
			else up = mid+1;
		}
		int row = down;
		// smaller than the first row first element,
		if (row<0) return false;
		
		int l = 0;
		int r = matrix[0].length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(target == matrix[row][mid]) return true;
			if(target<matrix[row][mid]) r= mid-1;
			else l = mid+1;
		}
		return false;
		
	}
	
	public boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[0].length-1]) return false;
		
		int i = 0;
		int j = 0;
		
		for(i = 0; i<matrix.length ; ++i) {
			if(matrix[i][0] > target) {
				break;
			}
		}
		
		for(j = 0; j<matrix[0].length; j++) {
			if(matrix[i-1][j] == target) return true;
		}
		
		return false;	
	}
	
	public static void main (String[] args) {
		Solution s = new Solution();
		int[][] A1= {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] A2= {{1},{20},{50}};
		int[][] A= {{1}};
		System.out.println(s.searchMatrix(A, 0));
		
	}
}