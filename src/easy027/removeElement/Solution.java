/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

package easy027.removeElement;

public class Solution {
	public int removeElement (int[] A, int elem) {
		if(A == null || A.length == 0) return 0;

		int count = 0;
		for(int i = 0 ; i < A.length; i++) {
			if(elem !=A[i]) {
				A[count] = A[i];
				count++;
			}
			
		}
		return count;
	
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a ={1,2,3,1,2,3};
		System.out.println(solution.removeElement(a, 1));
	}
}
