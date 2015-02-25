/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

package easy014.longestCommonPrefix;

public class Solution {
	public String longestCommenPrefix(String[] strs) {
		
		//Array is not null but empty, a proper way to demo it is strs.length == 0;
		if(strs == null || strs.length == 0) return "";
		
		if(strs[0] == null) return null;
		for(int i = 0 ; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j = 0; j<strs.length ; j++){
				//Handle the strs[j] array index out of bound, use || before the charAt(i)	
				if(i == strs[j].length() || strs[j].charAt(i) != c){
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		String[] sArray = {"12345","1234","123456"};
		Solution s = new Solution();
		System.out.println(s.longestCommenPrefix(sArray));
	}
}
