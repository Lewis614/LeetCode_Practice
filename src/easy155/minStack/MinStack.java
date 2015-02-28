package easy155.minStack;

public class MinStack {


	private StackNode head;
	private StackNode minNode;

	MinStack() {
		head = null;
		minNode = null;
	}

	public void push (int x) {
		StackNode node = new StackNode(x);
		if(head == null) {
			head = node;
			minNode= node;
			return;
		} 
		else {
			StackNode tempNode = head;
			head= node;
			node.succ = tempNode;
			if(head.val <= minNode.val) minNode = head;
		}
	}

	public void pop() {
		StackNode node = this.head;
		if (head == null) {
			minNode = null;
			return;
		}
		else {
			StackNode tempNode = head;
			head = head.succ;
			if(tempNode.val == minNode.val)  minNode = this.findMin();
		}

	}

	public int top() {
		if(head == null) return 0;
		else return head.val;
	}

	public int getMin() {
		if(head == null) return 0;
		else return minNode.val;
	}

	/**
	 * Supporting method to find min in Pop(). 
	 * @return
	 */
	public StackNode findMin() {

		if(head == null) return null;

		StackNode minPointerNode = head;

		// remember you are coding OO, you cannot change part of the object like minNode.val = minPointerNode.val;
		minNode = minPointerNode;

		while (minPointerNode.succ != null) {
			if(minPointerNode.succ.val <= minNode.val) {
				minNode = minPointerNode.succ;
			}
			minPointerNode = minPointerNode.succ;
		}
		return minNode;
	}


	public static void main(String[] args) {
		MinStack stack = new MinStack();
		//		stack.push(4);
		//		stack.push(7);
		//		stack.push(6);
		stack.push(1);
		stack.push(8);
		System.out.println(stack);
		//		System.out.println(stack.findMin().val);
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		//		System.out.println(stack.minNode.val);
		//		System.out.println(stack.findMin().val);

	}


	@Override
	public String toString(){
		String s = "[";
		StackNode pointNode = head;
		//Always consider if head == null, treat it separately!
		if (pointNode == null) return s+ "]";

		while(pointNode.succ != null) {
			s = s + pointNode.val+ ",";
			pointNode = pointNode.succ;
		}

		s = s + pointNode.val +"]";
		return s;
	}

}



class StackNode {

	int val;
	//	StackNode prev;
	StackNode succ;


	StackNode(){

		//		prev = null;
		succ = null;
	}

	StackNode(int x) {
		val = x;
		//		prev = null;
		succ = null;
	}
}
	
	
	
	
	
	