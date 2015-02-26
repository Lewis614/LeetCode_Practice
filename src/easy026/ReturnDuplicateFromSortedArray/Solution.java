/**
 * 
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */

package easy026.ReturnDuplicateFromSortedArray;



public class Solution {
	public int removeDuplicate(int[] A){
		//Always remember to handle the null and empty case, it is important!
		if(A == null || A.length == 0) return 0;
		
		if(A.length == 1) return 1;
		
		int count = 1;
		for(int i = 1 ; i < A.length ; i++) {
			if(A[i-1] != A[i]){
				A[count]= A[i];
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a ={1,1,2,2,2,3,3,2,2,1,2,3};
		System.out.println(solution.removeDuplicate(a));
	}
}

