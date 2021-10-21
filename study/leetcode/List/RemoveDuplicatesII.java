/**
 * 删除排序链表中的重复元素
 * @author georgechou
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesII {
	public ListNode deleteDuplicates(ListNode head) {
		if (null == head) {
			return null;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p1 = dummy;
		while (null != p1.next && null != p1.next.next) {
			if (p1.next.val == p1.next.next.val) {
				while (null != p1.next.next && p1.next.val == p1.next.next.val) {
					p1.next.next = p1.next.next.next;
				}
				p1.next = p1.next.next;
			} else {
				p1 = p1.next;
			}
		}

		return dummy.next;
	}
}
