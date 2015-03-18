package medium113.pathSumII;

import java.util.*;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> item= new ArrayList<Integer>();
		helper(root, 0, sum, res, item);
		return res;
	}
	
	public void helper(TreeNode root, int curTotal, int sum, ArrayList<List<Integer>> res,ArrayList<Integer> item) {
		
		if(root == null) return;
		
		curTotal +=root.val;
		item.add(root.val);
		helper(root.left,curTotal,sum,res,item);
		helper(root.right,curTotal,sum,res,item);
		
		if(root.left == null && root.right == null && curTotal == sum) {
			res.add(new ArrayList<Integer>(item));
		}
		// ZUO YONG FAN WEI YI DING YAO KAO LV QING CHU, 
		//ITEM will not automatically changed back when the recursive stack memory pop up the upper stack.  
		
		// Clean up the changes
		item.remove(item.size()-1);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode t1= new TreeNode(1);
		TreeNode t2= new TreeNode(2);
		TreeNode t3= new TreeNode(6);
		TreeNode t4= new TreeNode(4);
		TreeNode t5= new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		s.pathSum(t1,7);
		
	}
}

//Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}