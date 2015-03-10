package medium080.removeDuplicatesfromSortedArrayII;

// 20150121 10:50
public class Solution {

	// the solution is correct but the feedback seems to ask to change the array as well
	public int removeDuplicates(int[] A) {
		if(A ==null || A.length == 0) return 0;
		//if(A.length == 1 || A.length == 2) return A.length;
		int duplicate = 0;
		int count = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i-1] == A[i]) duplicate++;
			else duplicate=0;

			if(duplicate <2) {
				A[count] = A[i]; // index starting from 0 ---> Syntax trick: A[count++] = A[i]
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] res = {1,1,1,2,2,3,4,4,4,6};
		System.out.println(s.removeDuplicates(res));

	}
}
