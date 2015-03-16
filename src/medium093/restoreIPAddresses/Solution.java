package medium093.restoreIPAddresses;

import java.util.*;
public class Solution {
	public List<String> restoreIPAddress(String s){
		ArrayList<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0) return res;
		StringBuffer item = new StringBuffer();
		helper(s, 0, 1, item, res);
		return res;
	}
	
	public void helper(String s, int index, int group, StringBuffer item, ArrayList<String> res){
		
		//DO watch out the sequence of two if ending condition! 
		//first if is the correct to add res, second if is trimming the incorrect branch.
		//if(index == s.length() && group ==5){ // group == 5 means has finished 4, right now is 5 and Ok to terminate.
		if(item.length() == s.length()+3){  // better ending condition, if it is vaild, it must have three '.' so:s.length()+3
		res.add(item.toString());
			return;
		}
		
		if(index >s.length() || group>4) return;
		
		//Watch out: do not exceed to the boundary of the string s to calculate the substring!!!!! 
		for(int i = 1; i<=3 && (i+index<=s.length());i++){
			String subStr = s.substring(index,index+i);
			if(isValid(subStr)){
				if(item.length()==0){
					item.append(subStr);	
					helper(s, index+i, group+1, item, res);
					item.delete(item.length()-subStr.length(), item.length());
				}
				else{
					item.append('.');
					item.append(subStr);
					helper(s, index+i, group+1, item, res);
					item.delete(item.length()-subStr.length()-1, item.length());
				}
			}
		}
	}
	
	public boolean isValid(String str){
		if(str == null || str.length()>3) return false;
		int val = Integer.parseInt(str);
		
		//can not be something like 002, 020
		if(str.charAt(0)=='0'&&str.length() > 1) return false;
		if(val>=0 && val<=255) return true;
		return false;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "25525511135";
		List<String> res= s.restoreIPAddress(str);
	}
}
