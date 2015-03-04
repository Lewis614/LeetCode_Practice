package medium040.combinationSumII;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */


import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num == null || num.length == 0) return res;
		// the input should be pre-sorted.
		Arrays.sort(num);
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(num, target, 0, item, res);
		return res;
	}

	public void helper(int[] num, int target, int start, ArrayList<Integer> item, ArrayList<List<Integer>> res){
		if (target<0) return;
		if(target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for(int i = start; i<num.length; i++){
			//remember here!!!!! i is always compared with start, not 0;
			if(i>start && num[i-1]==num[i]) continue;
				item.add(num[i]);
				// here!!! if you dont want to always start from 0, use i+1 as Start.  
				helper(num, target-num[i], i+1,  item, res);
				item.remove(item.size()-1);

		}
	}

	public static void main(String[] args){
		Solution s = new Solution();
		int[] num = {10,1,2,7,6,1,5};
		System.out.println(s.combinationSum2(num, 8));
	}
}
