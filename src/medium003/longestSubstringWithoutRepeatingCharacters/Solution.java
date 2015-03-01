package medium003.longestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring2 (String s){
		
		// simple question but watch out for details.
		if(s == null || s.length() == 0) return 0;
		char[] strs = s.toCharArray();
		//walker and runner magic
		HashSet<Character> set = new HashSet<Character>();
		int walker = 0;
		int runner = 0;
		int resLen = 0;
		int res = 0; 
		while(runner <strs.length){
			if(!set.contains(strs[runner])) {
				set.add(strs[runner]);
				runner++;
				resLen++;
				res = Math.max(res, resLen);
			}
			else{
				set.remove(strs[walker]);
				walker++;
				resLen--;
			}
		}
		return res;
	}
	
	// Time Limit Exceed O(n^2)
	public int lengthOfLongestSubstring (String s){
		// simple question but watch out for details.
		if(s == null || s.length() == 0) return 0;
		//There is no need to trim since each character is a character, no matter what it is.
		//String str = s.replaceAll("[^A-Za-z]|\\s", "");
		char[] strs = s.toCharArray();
		int res = 0;
		for(int i = 0; i<strs.length; i++){
			int count = 0;
			HashSet<Character> set = new HashSet<Character>();
			for(int j = i; j<s.length(); j++){
				if(!set.contains(strs[j])){
					set.add(strs[j]);
					count++;
				}
				else {
					res = Math.max(count, res);
					break;
				}
			}
		}
		return res;
	}
	// worst Solution brute force O(n^3)
	
	public static void main (String[] args){
		Solution s = new Solution();
		String str = "abcabcebb";
		System.out.println(s.lengthOfLongestSubstring2(str));
	}
}
