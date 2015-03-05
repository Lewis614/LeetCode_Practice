package medium059.spiralMatrixII;

public class Solution {
	public int[][] generateMatrix(int n) {

		if (n < 0) return null;

		int[][] res = new int[n][n];

		int count = 1;
		int circleNum = n/2;

		for(int curCir= 0 ; curCir < circleNum ; curCir++) {
			for(int j = curCir ; j<n-1-curCir ; j++) {
				res[curCir][j] = count++;
			}
			for(int i = curCir ; i<n-1-curCir ; i++) {
				res[i][n-1-curCir] = count++;
			}
			for(int j = n-1-curCir ; j>curCir ; j--) {
				res[n-1-curCir][j] = count++;
			}
			for(int i = n-1-curCir; i>curCir; i--) {
				res[i][curCir] = count++;
			}
			
		}
		if(n%2==1) {
			res[n/2][n/2] = count++;
		}

		return res;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] A =s.generateMatrix(4);
	}
}
