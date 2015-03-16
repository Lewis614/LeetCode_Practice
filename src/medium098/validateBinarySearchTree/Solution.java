package medium098.validateBinarySearchTree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * @author liuyisi
 *
 */

public class Solution {
	// this is a better In-space solution 
	public boolean isValidBST2(TreeNode root){
		//Watch out the total null node tree.--here return true.
		if(root == null) return true;
		//only record the pre node to do comparison 
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>(); 
		pre.add(null);
		return helper2(root, pre);
	}
	
	//need a method to compare preNode and curNode;
	public boolean helper2(TreeNode root, ArrayList<TreeNode> pre){
		// terminate condition for each recursion. baseline.
		if(root == null) return true;
		
		boolean left = helper2(root.left, pre);
		
		//********middle part of the recursive function. MAKE THE MISTAKE ON pre.VAL>=cur.VAL again!!!
		if(pre.get(0) != null && pre.get(0).val >= root.val){
			return false;
		}
		//after use the root, set it to pre at the very last in middle part for next turn use.
		pre.set(0, root);
		//********
		
		boolean right = helper2(root.right, pre);
		
		// return recursively to track each node`s subtree(node as root of this subtree).
		return left && right;
	}
	
	
	
	public boolean isValidBST(TreeNode root){
		/*if it valid or not we should use in-order traversal to keep track of every node.
		the node val should be in ascending order,test the pre and cur node one by one, so
		you need to record the pre node as a global variable, using ArrayList as a jacket.
		*/
		
		// you should ask if null return what?
		if(root == null) return true;
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		helper(root, res);
		for(int i = 0; i< res.size()-1; i++){
			// VERY IMPORTANT EXPERIENCE: BST IS NOT ALLOWED THE DUPLICATED VALUE 
			if(res.get(i).val>= res.get(i+1).val) return false;
		}
		return true;
	}
	public void helper(TreeNode root, ArrayList<TreeNode> res){
		// must have this one to handle the leaf node`s child.
		if(root == null) return;
		helper(root.left, res);
		res.add(root);
		helper(root.right, res);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}