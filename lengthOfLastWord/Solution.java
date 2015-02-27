package easy058.lengthOfLastWord;

public class Solution {
	public int lengthOfLastWord(String s) {
		
		
		if(s == null) return 0;
		
		String[] ss = s.split(" ");
		if(ss.length == 0) return 0;
		else {
			String lastString = ss[ss.length-1];
			return lastString.length() ;	
		}
			
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int i = s.lengthOfLastWord(" ");
		System.out.println(i);
	}

}
