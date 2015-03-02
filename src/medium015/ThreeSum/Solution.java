package medium015.ThreeSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] num){

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(num == null || num.length == 0) return res;
		//Remember to sort the array!
		Arrays.sort(num);
		for(int i = num.length-1; i>2; i++){
			if(i<num.length-1 && num[i]== num[i+1]) continue;
			List<List<Integer>> curRes= twoSum(num, i-1, -num[i]);
			for(int j=0; j<curRes.size(); j++){
				curRes.get(j).add(num[i]);
			}
			res.addAll(curRes);
		}
		return res;
	}

	public List<List<Integer>> twoSum(int[] num, int end, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num== null || num.length == 0) return res;
		int l = 0;
		int r = end;
		while(l<r){
			if(num[l]+num[r] == target){
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);
				item.add(num[r]);
				// add the result to the final res.
				res.add(item);
				l++;
				r--;
				while(l<r && num[l] == num[l-1]) l++;
				while(l<r && num[r] == num[r+1]) r--;

			}
						
			else if (num[l]+num[r]>target) r--;
			else l++;	
		}
	
		return res;
	}
}
