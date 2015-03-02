package medium017.letterCombinationsofaPhoneNumber;

import java.util.*;
//20150126 11:20-12:30!! Finish by myself!!!!!!!
public class Solution {
	public List<String> letterCombination(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		if (digits == null) return res;
		//watch out the special situation
		if(digits.length() == 0){
			res.add("");
			return res; //can not directly return res.add("") [it is a boolean value to see if add succeed or not.]
		}
		StringBuffer item = new StringBuffer();
		helper(digits, res, item, 0);
		return res;

	}
	public void helper(String digits,List<String> res, StringBuffer item, int start){

		if(item.length() == digits.length()) {
			String finishedItem = new String(item.toString());
			res.add(finishedItem);
			return;
		}

		char[] dArray = digits.toCharArray();
		String curChars = map(dArray[start]);
		char[] cArray =curChars.toCharArray();
		for(int j = 0; j<cArray.length; j++) {
			//watch out the char -->string
			item.append(cArray[j]+"");
			helper(digits, res, item, start+1);
			item.deleteCharAt(item.length()-1);
		}
		/*
		char[] dArray = digits.toCharArray();
		for(int i = start; i < dArray.length; i++) {
			String curChars = map(dArray[i]);
			char[] cArray =curChars.toCharArray();
			for(int j = 0; j<cArray.length; j++) {
				//watch out the char -->string
				item.append(cArray[j]+"");
				helper(digits, res, item, start+1);
				item.deleteCharAt(item.length()-1);
			}
		}
		 */

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		List<String> res = s.letterCombination("23");
	}




	public String map(char input) {
		switch(input){
		case '1':
			return ""; 
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		case '0':
			return " "; //space ASCII code 32
		default:
			return "";

		}
	}

}
