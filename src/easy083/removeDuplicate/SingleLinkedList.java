/**
 * 20141121 00:15-01:05
 */
package easy083.removeDuplicate;



// remember to make full use of the existed data structure.
public class SingleLinkedList {

	SNode head;
	
	public SNode deleteDupulicates(SNode head) {
		if (head == null) return null;
		SNode pointer = head;
		while(pointer.next != null) {
			if(pointer.val == pointer.next.val){
				if (pointer == head) head = head.next;
				pointer.next = pointer.next.next;
			}
			else pointer = pointer.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		SingleLinkedList s = new SingleLinkedList();
//		SNode s1 = new SNode(1);
//		SNode s2 = new SNode(2,s1);
//		SNode s3 = new SNode(2, s2);
//		SNode s4 = new SNode(3,s3);
//		SNode s5 = new SNode(3, s4);
		s.head =null;
		System.out.println(s);
		s.deleteDupulicates(s.head);
		System.out.println(s);
	}
	 
}


class SNode {
	int val;
	SNode next;
	public SNode(int x) {
		val = x;
		next = null;
	}
	
	public SNode(int x , SNode n) {
		val = x;
		next = n;
	}
	
	
}




