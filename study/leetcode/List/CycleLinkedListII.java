/**
 * 环形链表 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class CycleLinkedListII {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		// 快慢指针，判断是否为环形链表
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (null == fast || null == fast.next) {
			return new ListNode(-1);
		}

		// 慢指针回到头结点，相遇的位置即为环形链表起点
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
