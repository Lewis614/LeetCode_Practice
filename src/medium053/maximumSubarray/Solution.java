package medium053.maximumSubarray;

public class Solution {
	public int maxSubArray(int[] A){
		
		int localMax = A[0];
		int globalMax = A[0];
		for(int i = 1 ; i<A.length ; i++) {
			localMax = Math.max(A[i], localMax+A[i]);
			globalMax = Math.max(localMax, globalMax);
		} 
		return globalMax;
	}
	
	public static void main(String[] args){
		
	}
}
