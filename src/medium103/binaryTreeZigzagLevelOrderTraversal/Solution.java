package medium103.binaryTreeZigzagLevelOrderTraversal;

import java.util.*;
// online solution with new data structure is not good as mine I think 
//http://blog.csdn.net/linhuanmars/article/details/24509105

// my own solution from last version of the level order traversal.
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) return res;
		// use LinkedList as queue, can have more flexibility so that queue can be used as a LinkedList as well
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		int key = 0;
		while(!queue.isEmpty()) {
			ArrayList<TreeNode> levelNodes = new ArrayList<TreeNode>();
			ArrayList<Integer> levelVal = new ArrayList<Integer>();


			while(!queue.isEmpty()){
				TreeNode node = queue.remove(queue.size()-1);
				levelNodes.add(node);
				levelVal.add(node.val);
			}
			
			key++;
			res.add(levelVal);
			
			// when queue is empty, use the listnodes to next level nodes into queue with proper order. 
			// i < levelNodes.size(), do not -1 for no reason. 
			for(int i = 0; i<levelNodes.size();i++){
				TreeNode node= levelNodes.get(i); 
				if(key%2 ==0){
					if(node.right != null) queue.add(node.right);
					if(node.left != null) queue.add(node.left);
				}
				else{
					if(node.left != null) queue.add(node.left);
					if(node.right != null) queue.add(node.right);
				}
			}

		}
		return res;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode t1= new TreeNode(1);
		TreeNode t2= new TreeNode(2);
		TreeNode t3= new TreeNode(3);
		TreeNode t4= new TreeNode(4);
		TreeNode t5= new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;

		List<List<Integer>> res = s.zigzagLevelOrder(t1);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}