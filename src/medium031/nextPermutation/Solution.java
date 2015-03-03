package medium031.nextPermutation;

import java.util.Arrays;

public class Solution {
	//---input:[1,3,2]----output:[3,1,2]-----correct:[2,1,3]
	// WRONG ANSWER
	public void nextPermutation (int[] num){
		if(num == null || num.length<=1) return;
		for(int i = num.length-1; i>0; i--){
			if(num[i-1]<num[i]){
				int temp = num[i-1];
				num[i-1] = num[i];
				num[i] = temp;
				return;
			}

		}
		Arrays.sort(num);
		return;
	}

	
	//RIGHT ANSWER
	public void nextPermutation2 (int[] num){
		if(num == null || num.length == 0) return;
		int i = num.length -2;

		while(i>=0 && num[i]>=num[i+1]){
			i--;
		}

		if(i>=0) {
			int j = i+1;
			
			//因为p右面的所有位数都保证了向后降序，所以最后如果找不到比p小的，那这个就是最后一个数位与p交换
			while(j<num.length && num[i]<num[j]){
				j++;
			}
			int index1 = i;
			int index2 = j-1;


			int temp = num[index1];
			num[index1] = num[index2];
			num[index2] = temp;
		}

		reverse(num, i+1);

	}

	public void reverse(int[] num, int start){
		if(num == null || num.length == 0) return;
		int l = start;
		int r = num.length -1;
		while(l<r){
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
			l++;
			r--;
		}
	}
	public static void main(String[] args){
		Solution s  = new Solution();
		int[] num = {1,2};
		s.nextPermutation2(num);
	}
}
