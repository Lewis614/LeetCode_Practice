/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

package easy169.majorityElement;

import java.util.*;

public class Solution {

	public int majorityElement(int[] num) {
		//Moore Vote algorithm : http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step13
		int key =num[0];
		int count=1;
		for(int i = 1 ; i < num.length ; i++) {
			if(count == 0) {
				key = num[i];
				count++;
			}
			
			else{
				if(num[i]==key) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		return key;
	}

	public int majorityElement2(int[] num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = num.length;
		for(int i = 0; i<n; i++) {
			int count =  map.containsKey(num[i]) ? map.get(num[i])+1 : 1;
			map.put(num[i], count);
		}

		int max = 0;
		int res =num[0];
		// remember this keySet() method. implement the iteration.
		for(int i : map.keySet()){
			if(max<map.get(i)) {
				max=map.get(i);
				res = i;
			}
		}
		return res;
	} 
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] a= {1,1,1,3,3,2,2,3,3,3,2,3,3};
		System.out.println(s.majorityElement(a));
	}
}
