/**
 * 删除排序链表中的重复元素
 * @author georgechou
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if (null == head) {
			return null;
		}

		ListNode p1 = head;
		while (null != p1.next) {
			if (p1.val == p1.next.val) {
				p1.next = p1.next.next;
			} else {
				p1 = p1.next;
			}
		}

		return head;
	}
}
