package medium016.threeSumClosest;

import java.util.*;

public class Solution {
	public int threeSumClosest(int[] num, int target){
		if(num == null || num.length <=2) return Integer.MIN_VALUE;
		Arrays.sort(num);
		int diff = num[num.length-1]+num[num.length-2]+num[num.length-3]-target;
		for(int i = num.length-1; i>=2; i--){
			int curDiff = twoSum(num, i-1, target-num[i]);
			if(Math.abs(curDiff)<Math.abs(diff)) diff = curDiff;
		}
		return target+diff;
		
	}
	
	public int twoSum (int num[], int end, int target){
		int l = 0;
		int r = end;
		int diff = num[end-1]+num[end]-target;
		while(l<r){
			if(num[l]+num[r]-target == 0)return 0;
			
			int curDiff = num[l]+num[r]-target;
			if(Math.abs(curDiff)<Math.abs(diff)){
				diff = curDiff;
			}
			
			if(num[l]+num[r]>target) r--;
			else l++;
		}
		return diff;
	}
}
