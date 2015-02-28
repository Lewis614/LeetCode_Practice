package easy107.binaryTreeLevelOrderTraversalII;
//https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 20141118 17:00
 */
import java.util.*;
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> reservedList = new ArrayList<List<Integer>>();
		if (root == null) return reservedList;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		queue.add(root);
		while (!queue.isEmpty()) {
			ArrayList<TreeNode> innerList = new ArrayList<TreeNode>();
			ArrayList<Integer> innerListValue = new ArrayList<Integer>();
			while(!queue.isEmpty()) {
				TreeNode node = queue.remove();
				innerList.add(node);
				innerListValue.add(node.val);
			}
			list.add(innerListValue);

			for(int i = 0 ; i < innerList.size(); i++) {
				TreeNode node = innerList.get(i);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}

		for(int i = 0 ; i < list.size(); i++) {
			reservedList.add(list.get(list.size()-1-i));
		}

		return reservedList;
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}