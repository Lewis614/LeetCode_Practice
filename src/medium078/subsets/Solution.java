package medium078.subsets;


/**
 * Given a set of distinct integers, S, return all possible subsetsNote:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, If S = [1,2,3], a solution is:
 */
import java.util.*;

public class Solution {
	
	// recursive solution for NP problem.
	public List<List<Integer>> subsets(int[] S) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> node = new ArrayList<Integer>();
		if(S == null) return null;
		
		res.add(node);
		if(S.length == 0) return res;
		Arrays.sort(S);
		
		for(int i = 0; i<S.length ; i++) {
			int size = res.size();
			for(int j = 0; j<size; j++){
				//Create a new copy of the node
				ArrayList<Integer> nodeCopy = new ArrayList<Integer>(res.get(j));
				nodeCopy.add(S[i]);
				res.add(nodeCopy);
			}
		}
		return res;
	}
	
}
