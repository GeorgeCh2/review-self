/**
 * 链表的中间结点
 * @author georgechou
 * @link https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleLinkedList {
	public ListNode middleNode(ListNode head) {
		// 快慢指针
		ListNode slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
