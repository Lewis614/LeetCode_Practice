package medium092.reverseLinkedListII;

import java.util.*;


public class Solution {
	
	
	// the in-space solution is to traverse the node from m to n, insert each one before m. 
	public ListNode reverseBetween2(ListNode head, int m, int n){
		if(head == null) return null;
		if(m>=n) return head;
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		
		int i = 1;
		while(pre.next != null && i<m){
			pre = pre.next;
			i++;
		}
		// means the link is not long enough
		if(i<m) return head;
		
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;
		
		// every time you need to reverse a link node, you need 4 node pointers to handle it.
		
		// Special notice on why use i<n and the cur pointer movement.
		while(cur != null && i<n){
			ListNode nextNode = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			mNode.next = nextNode;
			cur = nextNode;
			i++;
			
		}
		return helper.next;
		
	}
	// this is my own solution but not in space.
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		if(head == null) return null;
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		for(int i = 1; i<m; i++){
			pre = pre.next;
		}
		ListNode startPre = pre;
		Stack<ListNode> stack = new Stack<ListNode>();
		for(int j = m; j <= n; j++) {
			pre = pre.next;
			stack.push(pre);
		}
		ListNode end = pre.next;;
		
		while(!stack.isEmpty()) {
			startPre.next = stack.pop();
			startPre = startPre.next;
		}
		startPre.next = end;
		
		return helper.next;
	}
	
	public static void main(String[] args){
		ListNode a1 = new ListNode(1);
//    	ListNode a2 = new ListNode(2);
//    	ListNode a3 = new ListNode(3);
//    	ListNode a4 = new ListNode(4);
//    	ListNode a5 = new ListNode(5);
//    	ListNode a6 = new ListNode(6);
//    	a1.next = a2;
//    	a2.next = a3;
//    	a3.next = a4;
//    	a4.next = a5;
//    	a5.next = a6;
    	
    	Solution s = new Solution();
    	ListNode res = s.reverseBetween(a1, 1, 1);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
