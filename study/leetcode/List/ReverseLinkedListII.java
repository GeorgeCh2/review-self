/**
 * 反转链表 II
 * @author georgezhou
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		// 虚拟头节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		// 找到 left 之前的节点
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}

		ListNode cur = pre.next;
		ListNode next = cur.next;
		// 遍历翻转
		for (int i = left; i < right; i++) {
			ListNode temp = next.next;
			next.next = cur;
			cur = next;
			next = temp;
		}

		pre.next.next = next;
		pre.next = cur;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reverseBetween(head, 2, 4);
	}
}
