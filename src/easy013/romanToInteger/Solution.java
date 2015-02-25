/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999
 */


package easy013.romanToInteger;

public class Solution {
	public int romanToInt(String s) {
		// DEFINITELY BE AWARE OF THE NULL POINTER AND EMPTY STRING
		if(s == null || s.length() == 0) return 0;
		
		char[] sArray = s.toCharArray();
		int total = digitChange(sArray[0]);
		
		//DO REMEMBER ONCE YOU MAKE COMPARATION, YOU ARE COMPARE INT INSTEAD OF THE CHAR ASCII VALUE.
		
		for(int i = 1; i < sArray.length; i++){
			if(digitChange(sArray[i-1]) >= digitChange(sArray[i])) {
				total += digitChange(sArray[i]);
			}
			else total += (digitChange(sArray[i])-digitChange(sArray[i-1])*2);
		}
		return total;
	}
	
	public int digitChange(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.romanToInt("MMMCMXCIX"));
	}
}
