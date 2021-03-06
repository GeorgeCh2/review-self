import java.util.Stack;

/**
 * Implement Queue using Stacks
 * @author georgechou
 */
public class MyQueue {
	private Stack<Integer> inStack;

	private Stack<Integer> outStack;

	/** Initialize your data structure here. */
	public MyQueue() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		inStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (outStack.empty()) {
			in2Out();
		}

		return outStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (outStack.empty()) {
			in2Out();
		}

		return outStack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return inStack.empty() && outStack.empty();
	}

	private void in2Out() {
		while (!inStack.empty()) {
			outStack.push(inStack.pop());
		}
	}
}
