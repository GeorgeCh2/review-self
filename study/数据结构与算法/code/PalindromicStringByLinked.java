/**
 * 回文字符串（使用单链表进行判断）
 * @author georgechou
 */
public class PalindromicStringByLinked {
	/**
	 * 栈顶元素
	 */
	private static Node top;

	/**
	 * 将元素插入链表尾部
	 * @param element
	 */
	public void push(char element) {
		Node node = new Node(element, null);
		if (null == top) {
			top = node;
		} else {
			Node p = top;
			while (null != p.next) {
				p = p.next;
			}
			p.next = node;
		}
	}

	private static class Node {
		char item;
		Node next;

		Node(char item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node inverseLinked(Node p) {
		Node r = top;
		Node pre = null;
		Node next;
		while (r != p) {
			next = r.next;

			r.next = pre;
			pre = r;
			r = next;
		}
		r.next = pre;

		return r;
	}

	public boolean equalsString(Node left, Node right) {
		boolean result = true;
		while (null != left && null != right) {
			if (left.item != right.item) {
				result = false;
				break;
			}

			left = left.next;
			right = right.next;
		}

		return result;
	}

	public boolean palindorme() {
		if (null == top) {
			return false;
		} else {
			if (null == top.next) {
				return true;
			}

			// 慢指针
			Node slow = top;
			// 快指针
			Node fast = top;
			while (null != fast.next && null != fast.next.next) {
				slow = slow.next;
				fast = fast.next.next;
			}

			Node left;
			Node right;
			// 字符串长度为奇数，slow 指针指向的即为中点
			if (null == fast.next) {
				right = slow.next;
				left = inverseLinked(slow).next;
			} else {
				// 字符串长度为偶数
				right = slow.next;
				left = inverseLinked(slow);
			}
			return equalsString(left, right);
		}
	}

	public static void main(String[] args) {
		String str1 = "abcba";
		PalindromicStringByLinked linked = new PalindromicStringByLinked();
		for (char c : str1.toCharArray()) {
			linked.push(c);
		}

		System.out.print(linked.palindorme());
	}
}
