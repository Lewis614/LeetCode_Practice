/**
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *For example, given n = 3, a solution set is:
 *"((()))", "(()())", "(())()", "()(())", "()()()" 
 * 
 */

package medium022.generateParentheses;

import java.util.*;

public class Solution {
	public List<String> generateParenthesisList (int n) {
		ArrayList<String> res = new ArrayList<String>();
		if(n<0) return null;
		helper(res, n, n, "");
		return res;
	}
	
	//"left" is the number of left parenthesis and right is the number of right parenthesis. 
	public void helper(ArrayList<String> res,int left, int right, String str){
		//if right parenthesis is less than left, it is impossible to be valid. 
		if(right<left) return;
		if(right==0 && left ==0) {
			res.add(str);
			return;
		}
		if(left>0) helper(res, left-1, right, str+"(");
		if(right>0) helper(res, left, right-1, str+")");
	}
}
