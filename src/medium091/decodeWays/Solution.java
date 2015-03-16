package medium091.decodeWays;
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

 * @author liuyisi
 *
 */


public class Solution {
	//inspace solution:
	public int numDecodings2(String s){
		if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
		int num1 =1;
		int num2 =1;
		int num3 =1;
		
		for(int i = 1; i<s.length(); i++){
			if(s.charAt(i) == '0'){
				if(s.charAt(i-1)=='1'|| s.charAt(i-1)=='2') num3 = num1;
				// can not parse: 00, 30, 40, 50, 60, 70, 80, 90,
				else return 0;
			}
			else{
				if(s.charAt(i-1)>='3') num3 = num2;

				else{
					if(s.charAt(i-1)=='0' || (s.charAt(i-1)=='2' &&s.charAt(i)>='7')) num3= num2;
					else num3 = num2+num1;
				}
			}
			
			num1 = num2;
			num2 = num3;
		}
		
		return num2;
	}
	
	
	//O(N) Space solution 80min too much time waste!!
	public int numDecodings(String s){
		if(s == null || s.length() == 0) return 0;
		
		if(s.charAt(0) =='0') return 0;
		//DP: Compress the memory space to O(1) 
		int[] res = new int[s.length()]; 
		res[0]=1;
		
		for(int i = 1; i<s.length(); i++){
			if(s.charAt(i) =='0'){
				if(s.charAt(i-1)=='1' || s.charAt(i-1) == '2') {
					if(i==1){
						res[1]=1;
					}
					else res[i] = res[i-2];	
				}
				else return 0;
			}
			else{
				if(s.charAt(i-1)>='3' || s.charAt(i-1)=='2' && (s.charAt(i)>='7' && s.charAt(i)<='9') || s.charAt(i-1) =='0'){
					res[i] = res[i-1];
				}
				else{
					if(i==1){
						res[1] = 2;
					}
					else res[i] = res[i-1]+res[i-2];
				}
			}
		}
		
		return res[s.length()-1];
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "10";
		System.out.println(s.numDecodings2(str));
		System.out.println(Integer.MAX_VALUE);
	}
}
