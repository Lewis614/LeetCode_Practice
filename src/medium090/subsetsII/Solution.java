//http://blog.csdn.net/linhuanmars/article/details/24613193

package medium090.subsetsII;

import java.util.*;


public class Solution {
	
	public List<List<Integer>> subsetWithDup3(int[] num) {
		if(num == null) return null;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		if(num.length == 0) return res;
		//Dont forget the sorting before playing with the subset.
		Arrays.sort(num);
		
		//there no possible to be duplicated when only [] existed.
		int start = 0;
		
		for(int i = 0; i<num.length; i++) {
			int curSize= res.size();
			for(int j = start; j<curSize; j++) {
				ArrayList<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(num[i]);
				res.add(item);
			}
			
			// determine the starting pointer.(Watch out the boundary)
			if(i<num.length-1 && num[i] == num[i+1]){
				start = curSize;
			}
			else start = 0;
		}
		return res;
		
	}
	
	
	// my solution is not perfect, why list the one element separately? 
	public List<List<Integer>> subsetWithDup2(int[] num) {
		
		if(num == null) return null;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		if(num.length == 0) return res;
		
		Arrays.sort(num);
		//if num have only one element
		ArrayList<Integer> item1 =new ArrayList<Integer>(res.get(0));
		item1.add(num[0]);
		res.add(item1);
		int preSize=1;
		
		
		//starting from 2 elements
		for(int i=1; i<num.length; i++) {
			//remember to control the size.
			int curSize =res.size();
			
			if(num[i-1] == num[i]) {
				
				for(int j = preSize; j < curSize; j++) {
					ArrayList<Integer> item = new ArrayList<Integer>(res.get(j)); 
					item.add(num[i]);
					res.add(item);
				}
			}
			else{
				for(int j = 0; j < curSize; j++) {
					ArrayList<Integer> item = new ArrayList<Integer>(res.get(j)); 
					item.add(num[i]);
					res.add(item);
				}
			}
			preSize = curSize;
		}
		return res;
			
		
	}
	
	// rebuild the subsetI question, but need to update to II 
	public List<List<Integer>> subsetWithDup(int[] num) {		
		if(num == null) return null;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> firstItem = new ArrayList<Integer>(); 
		res.add(firstItem);
		if(num.length == 0) return res;
		
		Arrays.sort(num);
		
		for(int i=0; i<num.length; i++) {
			//remember to control the size.
			int curSize =res.size(); 
			for(int j = 0; j < curSize; j++) {
				ArrayList<Integer> item = new ArrayList<Integer>(res.get(j)); 
				item.add(num[i]);
				res.add(item);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] input = {2,2,2,2,2,2,2};
		List<List<Integer>>  res =s.subsetWithDup2(input);
	}
}
