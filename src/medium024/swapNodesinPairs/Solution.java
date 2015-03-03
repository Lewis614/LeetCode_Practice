/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * Yisi Liu 20150103 14:25_14：55 ONE TIME PASS!!!!!!
 * 
 */


package medium024.swapNodesinPairs;

public class Solution {
	public ListNode swapPairs(ListNode head){
		
		if(head == null || head.next == null) return head;
		
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode pre= h;
		
		while(head != null && head.next != null) {
			ListNode temp = head.next.next;
			pre.next = head.next;
			head.next.next = head;
			head.next = temp;
			
			pre = pre.next.next;
			head = head.next;
		}
		
		return h.next;
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		
		Solution s = new Solution();
		ListNode res = s.swapPairs(a1);
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