package medium082.removeDuplicatesfromSortedListII;
//http://blog.csdn.net/linhuanmars/article/details/24389429

public class Solution {
	public ListNode deleteDuplicates(ListNode head){
		if(head == null) return null;
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		ListNode cur = head;
		while(cur != null){
			while (cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}
			// pre.next = cur mean no duplicates.(cur does not change)
			if(pre.next == cur) pre = pre.next;
			else{
				pre.next =cur.next;
			}
			cur = cur.next;
		}
		return helper.next;
		
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