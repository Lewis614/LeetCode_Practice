/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */

package easy008.stringToInteger;

public class Solution {
	//atoi:ascii to int
	public int atoi (String str) {
		// please distinguish the \\ and // in Regular Expression	

		//DON NOT FORGET THE EMPTY STRING!YOU ALWAYS KEEPING FORGET IT !!!
		if(str == null || str.length() == 0) return 0;

		//Handle the blank space, using the class Regex.
		String s = str.replaceFirst("[\\s]*", "");
		
		// Set the initial value explicitly. and prepare for the possibility that the total can exceed to Integer.MAX_VALUE; 
		long total= 0l;

		//handle the sign
		if(s.charAt(0)=='-'){
			String nonSignStr = s.substring(1);
			char[] cArray = nonSignStr.toCharArray();
			for(int i = 0 ; i < cArray.length ; i++) {
				if(cArray[i]< 48 || cArray[i]> 57) return -1*(int)total;
				total = total * 10 + (cArray[i]-48);
				//if bigger than maximum Integer.
				if (total>Integer.MAX_VALUE) return Integer.MIN_VALUE;
			}
			return -1*(int)total;

		}
		// without the sign
		else if (s.charAt(0)== '+') {
			String nonSignStr = s.substring(1);
			char[] cArray = nonSignStr.toCharArray();
			for(int i = 0 ; i < cArray.length ; i++) {
				if(cArray[i]< 48 || cArray[i]> 57) return (int)total;
				total = total * 10 + (cArray[i]-48);

				if (total> Integer.MAX_VALUE) return Integer.MAX_VALUE;
			}
			return (int)total;
		}
		else{
			char[] cArray = s.toCharArray();
			for(int i = 0 ; i < cArray.length ; i++) {
				if(cArray[i]< 48 || cArray[i]> 57) return (int)total;
				total = total * 10 + (cArray[i]-48);
				if (total>Integer.MAX_VALUE) return Integer.MAX_VALUE;
			}
			return (int)total;
		}


	}
	public static void main(String[] args) {
//		System.out.println("  s df fdg  ".replaceFirst("[\\s]*", ""));

		Solution sol= new Solution();
		System.out.println(sol.atoi("+ 100"));
	}
}
