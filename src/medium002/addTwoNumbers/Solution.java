package medium002.addTwoNumbers;

public class Solution {
	//my solution is cleaner than LinHuan.
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode helper = new ListNode(1);
		ListNode pre = helper;
		int carry = 0;
		while(l1!= null && l2 != null){
			int digit = (l1.val + l2.val + carry)%10;
			carry = l1.val + l2.val + carry >=10 ? 1 : 0;
			ListNode cur = new ListNode(digit);
			pre.next = cur;
			pre = pre.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			int digit = (l1.val +carry) % 10;
			carry = l1.val + carry >=10 ? 1 : 0;
			ListNode cur = new ListNode(digit);
			pre.next = cur;
			pre = pre.next;
			l1 = l1.next;
		}
		while(l2 != null){
			int digit = (l2.val +carry) % 10;
			carry = l2.val + carry >=10 ? 1 : 0;
			ListNode cur = new ListNode(digit);
			pre.next = cur;
			pre = pre.next;
			l2 = l2.next;
		}
		if(carry == 1){
			ListNode cur = new ListNode(carry);
			pre.next = cur;
		}
		
		return helper.next;
	}
	
	
	
	//my solution but bad idea.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		//Boundary consideration
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		ListNode head1 = l1;
		ListNode head2 = l2;
		
		while(head1 != null){
			s1.append(head1.val);
			head1 = head1.next;
		}
		while(head2 != null){
			s2.append(head2.val);
			head2 = head2.next;
		}
		
		//int total = Integer.parseInt(s1.reverse().toString())+ Integer.parseInt(s2.reverse().toString());
		long total = Long.parseLong(s1.reverse().toString()) + Long.parseLong(s2.reverse().toString());
		
		ListNode pre = new ListNode(0);
		ListNode helper = pre;
		
		if(total == 0) return new ListNode(0);
		
		while(total>0){
			ListNode cur = new ListNode((int)(total%10));
			pre.next =cur;
			pre = pre.next;
			total /=10;
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