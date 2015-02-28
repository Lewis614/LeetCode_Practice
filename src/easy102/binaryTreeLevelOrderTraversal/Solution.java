package easy102.binaryTreeLevelOrderTraversal;
//https://oj.leetcode.com/problems/binary-tree-level-order-traversal/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while(!queue.isEmpty()) {
			ArrayList<TreeNode> innerList = new ArrayList<TreeNode>();
			ArrayList<Integer> innerListValue = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				innerList.add(node);
				innerListValue.add(node.val);
			}
			list.add(innerListValue);

			for (int i = 0 ; i < innerList.size(); i++) {
				TreeNode node = innerList.get(i);
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}

		}
		return list;
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}