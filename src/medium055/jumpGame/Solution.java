package medium055.jumpGame;
/**Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * 
 * @author liuyisi
 *
 */



public class Solution {
	//online solution:
	public boolean canJump3(int[] A) {  
	    if(A==null || A.length==0)  
	        return false;  
	    int reach = 0;  
	    for(int i=0;i<=reach&&i<A.length;i++)  
	    {  
	        reach = Math.max(A[i]+i,reach);  
	    }  
	    if(reach<A.length-1)  
	        return false;  
	    return true;  
	}  
	
	
	
	//O(n^2) time complexity: track if the index=i is available or not.
	//LeetCode will give you warning: Time Limit Exceeded
	 public boolean canJump2(int[] A) {
		 if(A == null || A.length == 0) return false;
		 // take care of the special case, if only one element, must true.
		 if(A.length == 1) return true;
		 boolean[] res = new boolean[A.length];
		 
		 res[0] = true;
		 for(int i = 1; i< A.length; i++) {
			 for(int j =0 ; j<i; j++) {
				 if(res[j] == true) {
					 if(j + A[j] >= i) {
						 res[i] = true;
						 break;
					 }
				 }
			 }
		 }
		 return res[A.length-1];
	 }
	
	
	//O(n) time complexity: solution by local and global tracking, greedy and DP.
	public boolean canJump(int[] A) {
		
		if(A== null || A.length == 0) return false;
		int local = 0;
		int global = 0;
		
		for(int i = 0; i< A.length; i++) {
			local = A[i]+i;
			global = Math.max(local, global);
			if(global == i && i < A.length-1) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] A = {2,3,1,1,4};
		int[] A = {3,2,1,0,4,3,4,5,6,7,8,2,4,3,2,1,3,4,6};
		System.out.println(s.canJump2(A));
	}
}
