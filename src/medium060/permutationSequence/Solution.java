package medium060.permutationSequence;
import java.util.*;



/**
 * The input is a set [1,2,3,É,n] --- which means no duplicate in set!
 * 
 * @author liuyisi
 *
 */

public class Solution {
	public String getPermutationString2 (int n, int k){
		
		if(n <= 0 ) return null;
		ArrayList<String> res = new ArrayList<String>();
		StringBuffer item = new StringBuffer();
		boolean[] used = new boolean[n];
		// boundary consideration:
		
		helper2(n, k, used, res, item);
		// WATCH OUT THE K!
		
		return res.get(k-1);
	}
	
	public void helper2(int n, int k, boolean[] used, ArrayList<String> res, StringBuffer item){
		if(item.length() == n){
			res.add(new String(item));
			return;
		}
		
		if (res.size() == k) {
			return;
		}
		for(int i = 0; i < n; i++){
			if(!used[i]){
				// Watch out the detail! value = index+1;
				item.append(i+1);
				used[i] = true;
				helper2(n, k, used, res, item);
				item.deleteCharAt(item.length()-1);
				used[i]= false;
			}
		}
	}
	
	
	// standard solution will cause TLE
	public String getPermutationString (int n, int k){
		
		if(n <= 0 ) return null;
		ArrayList<String> res = new ArrayList<String>();
		StringBuffer item = new StringBuffer();
		boolean[] used = new boolean[n];
		// boundary consideration:
		
		helper(n, used, res, item);
		// WATCH OUT THE K!
		if(k>res.size()) return null;
		
		return res.get(k-1);
	}
	
	public void helper(int n,  boolean[] used, ArrayList<String> res, StringBuffer item){
		if(item.length() == n){
			res.add(new String(item));
			return;
		}
		
		
		for(int i = 0; i < n; i++){
			if(!used[i]){
				// Watch out the detail! value = index+1;
				item.append(i+1);
				used[i] = true;
				helper(n, used, res, item);
				item.deleteCharAt(item.length()-1);
				used[i]= false;
			}
		}
	}
	public static void main(String[] args){
		Solution s  = new Solution();
		System.out.println(s.getPermutationString2(9, 78494));
	}
	
	
}
