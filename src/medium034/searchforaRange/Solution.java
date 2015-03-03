/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
//20150123 10:45
package medium034.searchforaRange;


public class Solution {
	
	// Best Solution online with only two times binary search:
	public int[] searchRange1 (int[] A, int target) {
		int[] range = {-1,-1};
		if(A == null || A.length == 0) return range;
		
		int left1 = 0;
		int right1 = A.length-1;
		
		// keep track of the right side.
		while(left1 <= right1) {
			int mid1 = (left1+right1)/2;
			if(A[mid1] <= target) left1 = mid1 +1;
			else right1 = mid1-1;
		}
		 
		
		int left2 = 0;
		int right2 = A.length-1;
		// keep track of the left side.	
		
		while(left2<=right2) {
			int mid2 = (left2+right2)/2;
			if(target <= A[mid2]) right2 = mid2-1;
			else left2 = mid2+1;
		}
		
		// which means the range is meaningful.
		if(left2<=right1){
			range[1] = right1;
			range[0] = left2; 	
		}
		
		return range;
	}
	
	
	
	// my solution: not sure it is O(logn), we have two search, one logn, one n, so the total should be n.
	public int[] searchRange (int[] A, int target) {
		int [] range = {-1,-1};
		if(A== null || A.length == 0) return range;
		
		int left = 0; 
		int right = A.length-1;
		
		// remember the binary search must have one step to let left = right and then l and r cross.
		while(left<=right) {
			int mid = (left+right)/2;
			if(A[mid] == target){
				int start = mid;
				int end = mid;
				// watch out for the array out of bound
				//while(A[start] == A[mid] && start >=0){
				while(start >=0 && A[start] == A[mid]){
					start--;
				}
				while(end < A.length && A[end]==A[mid]) {
					end++;
				}
				range[0]=start+1;
				range[1]=end-1;
				break;
			}
			else if(A[mid]>target) {
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return range;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] A = {1,3,3,3,3,3,3};
		int[] res = s.searchRange1(A, 3);
	}
	
}
