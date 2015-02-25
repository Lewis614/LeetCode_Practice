/**
 * Determine whether an integer is a 	. Do this without extra space.
 */

package easy009.palindromeNumber;

public class Solution {
	public boolean isPalindrome(int x) {
		//give them a default value explicitly, rather than leave it nothing. Can avoid a lot of initialization problems.
		
		//!!!!!!!Take care of the negative value as well
//		if(x<0) x = -x; talk with your interviewer, how to handle the negative value?
		if(x<0) return false;
		
		//you need to protect the orginal x value, it can be change in the method.
		int original = x;
		int remainder=0;
		int reverse=0;
		while(x>0) {
			remainder = x % 10;
			x = x/10;
			reverse = 10 * reverse + remainder;
		}
		if(reverse == original) return true;
		else return false;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome(-2147447412));
	}
}
