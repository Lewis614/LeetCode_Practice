package medium039.combinationSum;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		if(candidates == null) return null;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length == 0) return res;
		// sort the input first.
		Arrays.sort(candidates);
		
		helper(candidates, 0, 0, target, new ArrayList<Integer>(), res);
		return res;
	}
	
	public void helper(int[] candidates,int start, int sum, int target, ArrayList<Integer> item, ArrayList<List<Integer>> res) {
		
		// ending condition first!
		if(sum> target) {
			return;	
		}
		
		if(sum == target) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		
		for(int i = start; i<candidates.length; i++){
			/*take care of the duplicated elem in input array. OR it will generate duplicate result.
			given that that input is int[] array, which can have duplicate number,but the description mention:
			"Given a set of candidate numbers (C) and a target number (T)..." Set means no duplicated number.
			
			So it is not necessary to get AC in this task.
			*/
			//if(i>0 && candidates[i] == candidates[i-1]) continue;
			
			sum += candidates[i];
			item.add(candidates[i]);//
			
			//control whether it can use one element duplicated time(i) or just use each elem once(i+1)
			helper(candidates, i, sum, target, item, res);
			
			//clean up the changes
			item.remove(item.size()-1);
			sum -=candidates[i];
		}
		
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] a = {2,3,6,7}; 
		List<List<Integer>> res = s.combinationSum(a, 7);
	}
		
 
}
