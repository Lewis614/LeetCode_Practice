package medium106.constructBinaryTreefromInorderandPostorderTraversal;

//20:35--21:20-23:00

public class Solution {
	//good solution!!!
	public TreeNode buildTree1(int[] inorder, int[] postorder) {
		if(inorder==null||postorder==null||inorder.length==0
				||postorder.length==0||inorder.length!=postorder.length) return null;
		return helper1(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
	}
	public TreeNode helper1(int[] inorder, int[] postorder, int inl, int inr, int postl, int postr){
		if(inl>inr || postl>postr) return null;
		
		int rootVal = postorder[postr];
		int inordorRootIndex = inl;
		
		// use hashset can find the index in constant time.
		for(int i = inl; i<=inr; i++){
			if(inorder[i] == rootVal){
				inordorRootIndex = i;
				break;
			}
		}
		// left side:postl is concrete and add the Æ value to calculate the postr:[postl , postl+(inordorRootIndex-inl-1)]
		TreeNode  leftNode = helper1(inorder,postorder,inl,inordorRootIndex-1,postl,postl+(inordorRootIndex-inl)-1);
		// right side:postr is concrete and minutes the Æ value to calculate the postl:[(postr-1)-(inr-inordorRootIndex-1) , postr-1)]
		TreeNode  rightNode = helper1(inorder, postorder, inordorRootIndex+1,inr, postr-(inr-inordorRootIndex),postr-1);
		
		TreeNode rootNode = new TreeNode(rootVal);
		rootNode.left = leftNode;
		rootNode.right = rightNode;

		// use as a return value, to transfer to upper level, or it will disappear.
		return rootNode;
	}
	
	
	
	// only one set of left and right cannot work well.
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null||postorder==null||inorder.length==0
				||postorder.length==0||inorder.length!=postorder.length) return null;
		return helper(inorder,postorder,0,postorder.length-1);
	}
	public TreeNode helper(int[] inorder, int[] postorder, int left, int right){
		if(left>right) return null;
		
		int rootVal = postorder[right];
		int rootIndex = left;
		for(int i = left; i<=right; i++){
			if(inorder[i] == rootVal){
				rootIndex = i;
				break;
			}
		}
		
		TreeNode  leftNode = helper(inorder,postorder,left,rootIndex-1);
		TreeNode  rightNode = helper(inorder, postorder, rootIndex, right-1);
		
		TreeNode rootNode = new TreeNode(rootVal);
		rootNode.left = leftNode;
		rootNode.right = rightNode;

		// use as a return value, to transfer to upper level, or it will disappear.
		return rootNode;
	}
	

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] inorder = {4,2,5,1,6,3};
		int[] postorder = {4,5,2,6,3,1};
		TreeNode res = s.buildTree1(inorder, postorder);
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
