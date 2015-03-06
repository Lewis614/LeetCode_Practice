package medium061.rotateList;

public class Solution {
	public ListNode rotateRight(ListNode head, int n){
		if(head == null) return null;
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		int count =0;
		while(pre.next !=null){
			count++;
			pre = pre.next;
		}
		pre.next = head;
		int steps = count - n % count;
		pre = helper;
		for(int i = 0 ; i<steps; i++){
			pre = pre.next;
		}
		helper.next = pre.next;
		pre.next = null;
		return helper.next;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		ListNode a1 = new ListNode(1);
//		ListNode a2 = new ListNode(2);
//		ListNode a3 = new ListNode(3);
//		ListNode a4 = new ListNode(4);
//		ListNode a5 = new ListNode(5);
//		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;

		
		ListNode res = s.rotateRight(a1, 1);
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
