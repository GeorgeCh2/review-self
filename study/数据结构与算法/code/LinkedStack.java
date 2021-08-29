/**
 * @author georgechou
 * 链式栈
 */
public class LinkedStack<E> {
	transient int size = 0;

	/**
	 * 栈顶
	 */
	transient Node<E> top;

	public boolean push(E item) {
		Node<E> node = new Node<>(item, null);
		if (null != top) {
			node.next = top;
		}
		top = node;
		size++;
		return true;
	}

	public E pop() {
		if (size == 0) {
			return null;
		}

		E item = top.item;
		top = top.next;

		return item;
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		System.out.print(String.format("%s %s %s", stack.pop(), stack.pop(), stack.pop()));
	}