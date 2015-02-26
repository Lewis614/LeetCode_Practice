package easy028.strStr;

public class Solution {

	public int strStr(String haystack, String needle) {
		// null does not equal to ""
		// if needle is "" will no match for sure
		if(haystack == null || needle == null) return -1;
		if(needle == "") return 0;
		if(needle.length()> haystack.length()) return -1;
		for(int i = 0; i <= haystack.length()-needle.length();i++) {
			boolean flag = true;
			for(int j = 0; j<needle.length();j++) {
				if(haystack.charAt(j+i) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				return i;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.strStr("c", "c"));
		
	}
}
