/**
 * 环形链表
 * @author georgechou
 * @link https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class CycleLinkedList {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}

		return true;
	}
}
