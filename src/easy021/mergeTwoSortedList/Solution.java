package easy021.mergeTwoSortedList;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null ) return l2;
        if(l1 != null && l2 == null ) return l1;
        ListNode pointer = new ListNode(0);
        ListNode head = pointer;
        while(l1!= null && l2!= null) {
            if(l1.val >= l2.val) {
                pointer.next = l2;
                l2 = l2.next;
                pointer = pointer.next;
            }
            else {
                pointer.next = l1;
                l1 = l1.next;
                pointer = pointer.next;
            }

        }
        
        if (l1 != null) {
            pointer.next = l1;
        }
        if (l2 != null) {
            pointer.next = l2;
        }
        return head.next;
     }
    
    public static void main (String[] args) {
    	ListNode a1 = new ListNode(1);
    	ListNode a2 = new ListNode(3);
    	ListNode a3 = new ListNode(5);
    	ListNode b1 = new ListNode(3);
    	ListNode b2 = new ListNode(6);
    	ListNode b3 = new ListNode(9);
    	ListNode b4 = new ListNode(11);
    	a1.next = a2;
    	a2.next = a3;
    	b1.next = b2;
    	b2.next = b3;
    	b3.next = b4;
    	
    	Solution s = new Solution();
    	ListNode result = s.mergeTwoLists(a1, b1);
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