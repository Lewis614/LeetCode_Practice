package medium114.flattenBinaryTreetoLinkedList;


import java.util.*;


public class Solution {

	
	/* WHY this solution cannot work? -- pointer is changing during the recursive.
	 * 
	 */
	/*
	public void flatten2(TreeNode root) {
		TreeNode pre = null;
		helper2(root,pre);
		
	}
	
	public void helper2 (TreeNode root, TreeNode pre) {
		// watch out forgetting the ending condition.
		if(root == null) return;		
		TreeNode tempRight = root.right;
		if(pre!= null) {
			pre.left = null;
			pre.right = root;
		}
		
		pre= root;
		helper2(root.left, pre);
		helper2(tempRight, pre);
	}

	*/
	
	//In-space solution:
	public void flatten1(TreeNode root) {
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
		helper1(root,pre);
		
	}
	
	public void helper1 (TreeNode root, ArrayList<TreeNode> pre) {
		// watch out forgetting the ending condition.
		if(root == null) return;		
		TreeNode tempRight = root.right;
		if(pre.get(0) != null) {
			pre.get(0).left = null;
			pre.get(0).right = root;
		}
		
		pre.set(0, root);
		helper1(root.left, pre);
		helper1(tempRight, pre);
	}
	
	
	// my solution using stack, not the inspace solution and practice the inorder traversal again. 
	public void flatten(TreeNode root) {
		// Boundary protection should exist as long as possible, no harm.
		if(root == null) return;
			
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		
		while(root != null || !stack.isEmpty()){
			if(root != null) {
				stack.push(root);
				res.add(root);
				root = root.left;
			}
			else{
				root = stack.pop();
				root = root.right;
			}
				
		}
		root = res.remove(0);
		while(!res.isEmpty()){
			root.right = res.remove(0);
			// clean the original setting
			root.left = null;
			root = root.right;
		}
	}
	
	public static void main(String[] args)  {
		Solution s =new Solution();
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		s.flatten1(t1);
	}
}



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}