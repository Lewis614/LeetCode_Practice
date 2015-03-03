package medium029.divideTwoIntegers;

public class Solution {
	
	//No much meaning in coding preparation.
	public int divide2(int dividend, int divisor){
		if(divisor == 0) return Integer.MAX_VALUE;
		return -1;
	}
	
	
	// Can not pass some of the corner case about the Integer.MAX_VALUE and Integer.MIN_VALUE.
	public int divide(int dividend, int divisor){
		if(divisor == 0) return Integer.MAX_VALUE;
		int count = 0;
		
		int absDividend = Math.abs(dividend);
		int absDivisor = Math.abs(divisor);
		
		while(absDividend >=absDivisor){
			//watch out the +/-
			absDividend -= absDivisor;
			count++;
		}
		if(dividend*divisor>= 0) return count;
		else return -count;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.divide(-9,3));
	}
}
