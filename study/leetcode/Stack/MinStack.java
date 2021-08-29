public class MinStack {
	/**
	 * 栈顶元素
	 */
	private Node top;

	/**
	 * 最小元素
	 */
	private Node minNode;

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int val) {
		if (null == top) {
			top = new Node(val, null);
			minNode = top;
		} else {
			top = new Node(val, top);
			minNode = val < minNode.item ? top : minNode;
		}
	}

	public void pop() {
		if (null != top) {
			if (minNode == top) {
				Node node = top.next;
				minNode.item = Integer.MAX_VALUE;
				while (null != node) {
					minNode = node.item < minNode.item ? node : minNode;
					node = node.next;
				}
			}
			top = top.next;
		}
	}

	public int top() {
		if (null == top) {
			return -1;
		}
		return top.item;
	}

	public int getMin() {
		if (null == minNode) {
			return -1;
		}

		return minNode.item;
	}

	private static class Node {
		int item;
		Node next;

		Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}
}
