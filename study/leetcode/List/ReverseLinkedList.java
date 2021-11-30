/**
 *  翻转链表
 * @author georgechou
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (null != cur) {
			ListNode next = cur.next;
			cur.next = pre;

			pre = cur;
			cur = next;
		}

		return pre;
	}
}
