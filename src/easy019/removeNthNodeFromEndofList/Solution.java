package easy019.removeNthNodeFromEndofList;

public class Solution {
	public ListNode removeNthFromEnd (ListNode head, int n) {
		if (head == null) return null;
		if(n>length(head) || n <= 0) return null;
		//headle the change of the head.
		else if(n == length(head)) {
			head = head.next;
		}
		else {
			ListNode p = head;
			// must be initialized
			ListNode prev = head;
			for(int i = 0; i< length(head) - n; i++ ){
				prev = p;
				p = p.next;
			}
			prev.next = p.next;
		}
		return head;
	}

	public int length(ListNode head){
		if (head == null) return 0;


		int count = 1;
		while(head.next != null){
			head = head.next;
			count++;

		}
		return count;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(8);
		ListNode l5 = new ListNode(10);
		ListNode l6 = new ListNode(12);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		Solution s  = new Solution();
		ListNode result= s.removeNthFromEnd(l1, 7);
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