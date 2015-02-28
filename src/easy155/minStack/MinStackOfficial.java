package easy155.minStack;

import java.util.*;



public class MinStackOfficial {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);
		// the <= should be always contain =, or you pop the stack and lose the invariant.
		if(minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
	}

	public void pop() {
		// this is Object, you can not do ==, if you want to compare with value, DO USE THE METHOD .equals()
		//		if(minStack.peek() == stack.peek()) minStack.pop();
		if(minStack.peek().equals(stack.peek())) minStack.pop();
		stack.pop();
	}
	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}


	public static void main(String[] args) {
		MinStackOfficial stack = new MinStackOfficial();
		//		stack.push(4);
		//		stack.push(7);
		stack.push(1);
		stack.push(6);
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
}



/*
public class MinStackOfficial {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

 */