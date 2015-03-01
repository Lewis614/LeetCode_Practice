package easy160.intersectionofTwoLinkedLists;

import java.util.*;


public class Solution {
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
		
		// find if exist
		ListNode pa = headA;
		ListNode pb = headB;
		while(pa.next != null){
			pa = pa.next;
		}
		ListNode lastA = pa;
		while(pb.next != null){
			pb = pb.next;
		}
		ListNode lastB = pb;
		if(lastA != lastB) return null;
		
		//if exist, find where is the intersection.
		pa = headA;
		pb = headB;
		while(pa != pb) {
			if(pa.next == null){
				pa = headB;
			}
			else pa = pa.next;
					
			if(pb.next == null){
				pb = headA;
			}
			else pb = pb.next;
		}
		return pa;
	}
	
	// correct solution!
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
		ListNode pa = headA;
		ListNode pb = headB;
		ListNode lastA = null;
		ListNode lastB = null;
		while(pa != pb) {
			if(pa.next == null){
				lastA = pa;
				pa = headB;
			}
			else pa = pa.next;
					
			if(pb.next == null){
				lastB = pb;
				pb = headA;
			}
			else pb = pb.next;
			
			if(lastA != lastB || lastA != null || lastB != null) return null;
		}
		return pa;
	}
	
	
	//20150123 13:00-13:30
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
		
		Stack<ListNode> a = new Stack<ListNode>();
		Stack<ListNode> b = new Stack<ListNode>();
		ListNode p1 = headA;
		ListNode p2 = headB;
		
		// it will cause O(n) new space, 
		//since each time you call push, you create a new space to store the TreeNode is this stack
		while(p1 != null){
			a.push(p1);
			p1 = p1.next; 
		}
		while(p2 != null){
			b.push(p2);
			p2 = p2.next;
		}
		
		ListNode res = null;
		while(!a.isEmpty() && !b.isEmpty() && a.peek() == b.peek()) {
			res = a.peek();
			a.pop();
			b.pop();
		}
		return res;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode a1 = new ListNode(1);
		ListNode a2 = a1;
		s.getIntersectionNode1(a1, a2);
	}
	
}

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}