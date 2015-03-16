package medium094.binaryTreeInorderTraversal;

import java.util.*;

public class Solution {

	// recursive solution which should be demonstrated at first
	
	public List<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		helper(root,res);
		return res;
	}
	public void helper(TreeNode root, ArrayList<Integer> res){
		if(root == null) return;
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
	
	//online solution, so efficient!much better than mine!
	public List<Integer> inorferTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.isEmpty()){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
	
	//My solution is kind of confusing and not good to handle the stack.
	//From now on, always follow the online solution!
	public List<Integer> inorderTraversal2(TreeNode root) {
		//Negotiate with interviewer for null situation.
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode,Integer>();		
		TreeNode pointer = null;
		stack.push(root);
		while(!stack.isEmpty()){
			pointer = stack.peek();
			if(pointer.left != null && !map.containsKey(pointer)){
				map.put(pointer, pointer.val);
				stack.push(pointer.left);
				continue;
			} 
			
			pointer = stack.pop();
			res.add(pointer.val);
			
			if(pointer.right != null) {
				stack.push(pointer.right);
				continue;
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.right = b;
		b.left = c;
		Solution s = new Solution();
		System.out.println(s.inorderTraversal(a));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
