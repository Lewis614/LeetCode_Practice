package medium086.partitionList;



// 20150124 18:40-19:10, misunderstanding of the description.
// 20150125 14:10-16:15
public class Solution {

	//if smaller, put it into the head (My first solution is if >= put it to the tail.)

	public ListNode paration1 (ListNode head, int x) {
		if(head == null) return head;
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode walker = helper; // keep track of the last node which smaller than target.
		ListNode runner = helper; //traversal node
		// if any node val <x, put it to the helper.next(there we have the helper node, much easier than my solution at tail)
		while(runner.next != null){
			if(runner.next.val<x){
				if(walker == runner) {
					runner = runner.next;
				}
				else{
					ListNode temp = runner.next.next;
					runner.next.next = walker.next;
					walker.next = runner.next;
					runner.next = temp;
				}
				walker = walker.next;
			}
			else{
				runner = runner.next;
			}
		}
		return helper.next;

	}

	//147/166 TEST CASES PASSED.(first code add a x<0,so it is not passed!)
	//SUCCEED! waste one hour to check where is wrong.(!!!!!WRONG)if(head == null || x<0) return head;
	public ListNode paratition (ListNode head, int x) {
		//did not change the list at all.
		if(head == null) return head;

		// the head can be changed as well.
		ListNode pre= new ListNode(0);
		pre.next = head;
		ListNode curPre = pre;
		ListNode tail= head;
		while(tail.next != null) tail = tail.next;
		ListNode curTail = tail;
		// Logic: if the node is >= target, put it to the lastNode.
		while(head!= tail) {
			if(head.val>=x) {
				pre.next =head.next;
				head.next = null;
				curTail.next = head;
				curTail = curTail.next;
				head = pre.next;
			}
			else{
				head = head.next;
				pre = pre.next;
			}
		}
		// if head = tail;
		if(tail.next == null){
			//do nothing
		}
		else{
			if(head.val>=x) {
				pre.next =head.next;
				head.next = null;
				curTail.next = head;
				curTail = curTail.next;
			}
		}

		return curPre.next;

	}
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		//		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		s.paratition(l1, 3);
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