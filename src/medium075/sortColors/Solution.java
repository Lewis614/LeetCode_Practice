/**
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * 20150103 17:05
 */

package medium075.sortColors;

public class Solution {

	//One Pass Solution.
	public void sortColors2(int[] A) {
		int i0 =0;
		int i1 =0;
		int i2 =0;
		
		for(int i = 0 ; i < A.length ; i++) {
			if(A[i]==0){
				A[i2]=2;
				A[i1]=1;
				A[i0]=0;
				i0++;
				i1++;
				i2++;
			}
			else if(A[i]==1){
				A[i2]=2;
				A[i1]=1;
				i1++;
				i2++;
			}
			else{
				A[i2]=2;
				i2++;
			}
		}

	}

	// Two Pass Solution.
	public void sortColors(int[] A) {
		if(A == null || A.length == 0) return;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for(int i = 0; i < A.length; i++) {
			if(A[i]==0) count1++;
			else if(A[i]==1) count2++;
			else count3++;
		}
		for(int j = 0; j<A.length; j++){
			if(j<count1) A[j] =0;
			else if(j<count2+count1) A[j] = 1;
			else A[j] =2;
		}
	}

	public static void main(String[] args) {

	}
}
