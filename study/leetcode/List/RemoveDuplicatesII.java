/**
 * 删除排序链表中的重复元素
 * @author georgechou
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1, head), slow = dummy, fast = head;
		while (null != slow.next) {
			if (null == fast.next || fast.val != fast.next.val) {
				if (slow.next != fast) {
					slow.next = fast.next;
				} else {
					slow = slow.next;
				}
			}
			fast = fast.next;
		}

		return dummy.next;
	}
}
