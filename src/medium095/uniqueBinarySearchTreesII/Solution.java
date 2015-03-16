package medium095.uniqueBinarySearchTreesII;

import java.util.*;

public class Solution {

	public List<TreeNode> generateTrees(int n) {
		return helper(1,n);
	}

	public ArrayList<TreeNode> helper (int left,int right) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(left > right) {
			// why add null? need to protect the structure of the tree is correct.
			res.add(null);
			return res;
		}
		
		//divide and conquer
		for(int i = left; i <= right; i++) {
			ArrayList<TreeNode> leftList = helper(left, i-1);
			ArrayList<TreeNode> rightList = helper(i+1, right);
			for(int j = 0; j<leftList.size(); j++) {
				for(int k = 0; k<rightList.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		Solution s = new Solution();
//		List<TreeNode> res = s.generateTrees(3);
		List<TreeNode> res = new ArrayList<TreeNode>();
		res.add(null);
		res.add(null);
	}

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null; }
}