package medium035.searchInsertPosition;

public class Solution {
	public int searchInsert(int[] A , int target) {
		//if(A == null || A.length == 0) return 0;
		for(int i = 0 ; i < A.length ; i++) {
			if(A[i]<target) continue;
			else return i;
		}
		return A.length;
	}
}
