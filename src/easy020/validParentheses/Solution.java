/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

package easy020.validParentheses;
import java.util.*;

import javax.swing.Popup;

public class Solution {

	public boolean isValid(String s) {
		
		if (s == null) return false;
		
		char[] cArray = s.toCharArray();
		Stack<String> stack = new Stack<String>();
		for(int i = 0 ; i< cArray.length ; i++) {
			
			//Please take care of the char -->String , because no method can treat char as a String to be the input.
			if(cArray[i] == '(' || cArray[i] == '{' || cArray[i] == '[') {
				stack.push(cArray[i]+"");
			}
			else{
				//handle the empty stack first! --->case: }])
				if(stack.isEmpty()) return false;
				
				String pop = stack.pop();
				String compareChar = cArray[i] +"";
				//Please DO DISTINGUISH THE DIFFERENCE BETWEEN THE .equals() and ==
				if(pop.equals("(") && compareChar.equals(")")) continue; 
				if(pop.equals("[") && compareChar.equals("]")) continue;
				if(pop.equals("{") && compareChar.equals("}")) continue;
				
				return false;
			}
		}
		//handle the case: {[(
		if (stack.isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("["));
		
		
	}
	
}
