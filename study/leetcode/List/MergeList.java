/**
 * 合并两个有序列表
 * @author georgechou
 * @link https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 虚拟头节点
		ListNode dummy = new ListNode(-1), p = dummy;

		// 遍历两个链表
		while (null != l1 && null != l2) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		p.next = null == l1 ? l2 : l1;

		return dummy.next;
	}


}
