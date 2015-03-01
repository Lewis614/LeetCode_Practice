package easy189.rotateArray;


public class Solution {
	//In-space solution
	public void rotate2 (int[] nums, int k){
		if(nums == null || nums.length == 0 || k<0) return;
		int len = nums.length;
		int steps = k % len;
		
		reverse(nums, 0, len-1);
		reverse(nums, 0, steps-1);
		reverse(nums, steps, len-1);

	}
	
	public void reverse(int[] nums, int l, int r){
		if(nums== null || nums.length == 0) return;
		while(l<r){
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			
			//you always forget to move the pointer!
			l++;
			r--;
		}
	}


	//Time O(n), Space: O(n)
	public void rotate (int[] nums, int k){
		if(nums == null || nums.length == 0 || k<0) return;
		int len = nums.length;
		int rotate = k % len;

		int[] res = new int[len];
		for(int i = 0; i<len; i++){
			res[(i+rotate)%len] = nums[i];
		}
		//Cannot directly point to nums, java copy the address and here just the copy of address point to the new result.
		//nums = res;

		//you need to traverse again to update the elem.
		for(int i = 0; i<len; i++){
			nums[i] = res[i];
		}
	}

	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,2,3,4,5,6};
		s.rotate2(nums, 2);
	}
}
