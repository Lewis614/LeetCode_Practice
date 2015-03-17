package medium109.convertSortedListtoBinarySearchTree;

public class Solution {
	
	ListNode pointer;
	
	public TreeNode sortedListToBST(ListNode head) {  
		if(head == null) return null;
		pointer = head;
		return helper(0,listLength(head)-1);
	}  
	public TreeNode helper(int left,int right){
		if(left>right) return null;
		
		int middle = (left + right)/2;
		
		TreeNode leftNode = helper(left, middle-1);
		TreeNode root = new TreeNode(pointer.val); 
		pointer = pointer.next;
		TreeNode rightNode = helper(middle+1, right);
		
		root.left = leftNode;
		root.right = rightNode;
		
		return root;
	}
	
	
	public int listLength(ListNode head) {
		int count = 0;
		while(head!= null) {
			count++;
			head = head.next;
		}
		return count;
	}
	

	public static void main(String[] args){
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		
		
		
		Solution s = new Solution();
		TreeNode res = s.sortedListToBST(a1);
	}
}
//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}

// Definition for binary tree 
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
