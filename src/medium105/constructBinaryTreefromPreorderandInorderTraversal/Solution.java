package medium105.constructBinaryTreefromPreorderandInorderTraversal;


//20150126 16:00-16:20start coding, 16:30finish.
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder== null || inorder == null || preorder.length == 0 || inorder.length ==0
				|| preorder.length != inorder.length) return null;
		return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
		
	}

	public TreeNode helper(int[] preorder, int[] inorder, int prel, int prer, int inl, int inr){
		
		// remember only if l > r , this recursion can be stopped!
		if(prel > prer || inl > inr) return null;
		
		
		int rootVal = preorder[prel];
		int inorderIndex = prel;
		//here you not use any magical number, since it is in the recursion right now, how can you know the i starting from 0? 
		for(int i = inl; i <= inr;i++){
			if(rootVal== inorder[i]) {
				inorderIndex = i;
				break;
			}
		}
		
		TreeNode leftNode = helper(preorder, inorder, prel+1, prel+1+(inorderIndex-inl-1), inl, inorderIndex-1);
		TreeNode rightNode = helper(preorder, inorder, prer-(inr-inorderIndex-1), prer, inorderIndex+1, inr);
		
		TreeNode root = new TreeNode(rootVal);
		root.left = leftNode;
		root.right = rightNode;
		
		return root;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] inorder = {4,2,5,1,6,3};
		int[] preorder = {1,2,4,5,3,6};
		TreeNode res = s.buildTree(preorder, inorder);
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		val = x;
	}
}