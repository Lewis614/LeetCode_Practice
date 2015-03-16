package medium089.grayCode;

import java.security.interfaces.RSAKey;
import java.util.*;

public class Solution {
	public List<Integer> grayCode(int n){
		if(n<0) return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(n==0) {
			res.add(0);
			return res;
		}
		res.add(0);
		res.add(1);
		for(int i = 2; i<=n; i++) {
			int curSize = res.size();
			for(int j = curSize-1; j>=0; j--) {
				res.add(res.get(j) + (1<<(i-1)));
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.grayCode(8));
	}
}
