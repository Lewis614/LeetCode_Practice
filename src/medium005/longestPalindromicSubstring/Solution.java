package medium005.longestPalindromicSubstring;

public class Solution {
	//DP solution:
	public String longestPalindrome3(String s){
		if(s == null || s.length() == 0) return null;
		boolean[][] res = new boolean[s.length()][s.length()];
		String str = "";
		int max = 0;
		for(int i = s.length()-1; i>=0; i--){
			for(int j = i; j<s.length();j++){
				if(s.charAt(i)== s.charAt(j) && (j-i<=2 || res[i+1][j-1])){
					res[i][j]= true;
					//if(str.length()<s.substring(i, j+1).length()) str = s.substring(i,j+1);
					if(max <j-i+1){
						max = j-i+1;
						str = s.substring(i,j+1);
					}
				}
			}
		}
		return str;
	}
	
	
	
	//better solution:
	public String longestPalindrome2(String s){
		if(s ==  null ||s.length() == 0) return null;
		int maxLength = 0;
		String res = "";
		for(int i = 0; i<2*s.length()-1; i++){
			int left = i/2;
			int right = i/2;
			if(i%2 == 1) right++;
			String str = longestSub(s, left, right);
			if(maxLength < str.length()){
				maxLength = str.length();
				res = str;
			}
		}
		return res;
			
	}
	
	public String longestSub(String s, int left, int right){
		//watch out the sequence of the constrains. first is boundary limitation.
		//than is length()-1 to the right end.
		while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}

	

	// this solution is O(n^2) can not pass the big test case
	public String longestPalindrome(String s){
		if(s == null || s.length() == 0) return "";
		for(int len = s.length(); len>=1; len--){
			for(int i =0; i+len<=s.length(); i++){
				if(isPalindromw(s.substring(i,i+len))){
					return s.substring(i,i+len);
				}
			}	
		}
		return null;

	}
	//more precise solution
	public boolean isPalindromw(String s){
		if(s.length()<=1) return true;
		return (s.charAt(0)==s.charAt(s.length()-1)) && isPalindromw(s.substring(1,s.length()-1));
	}
	/*
	public boolean isPalindrome(String s){
		if(s.length()<=1) return true;
		if(s.charAt(0) == s.charAt(s.length()-1)){
			return isPalindrome(s.substring(1,s.length()-1));
		}
		return false;
	}
	 */

	public static void main(String[] args){
		Solution s = new Solution();
		String str = "dadqwertyuiiuytrewqdsafgfd";
		System.out.println(s.longestPalindrome3(str));
		System.out.println(str.length());
	}

	
	//************************************************************************************
	public String longestPalindrome_Online(String s) {  
		if(s == null || s.length()==0)  
			return "";  
		int maxLen = 0;  
		String res = "";  
		for(int i=0;i<2*s.length()-1;i++)  
		{  
			int left = i/2;  
			int right = i/2;  
			if(i%2==1)  
				right++;  
			String str = lengthOfPalindrome2(s,left,right);  
			if(maxLen<str.length())  
			{  
				maxLen = str.length();  
				res = str;  
			}  
		}  
		return res;  
	}  
	private String lengthOfPalindrome2(String s, int left, int right)  
	{  

		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))  
		{  
			left--;  
			right++;  
		}  
		return s.substring(left+1,right);  
	}  
}
