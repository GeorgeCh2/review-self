import life.codecook.leetcode.easy.ListNode;

/**
 * 分割链表
 * @author georgechou
 * @link https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(-1);
		ListNode large = new ListNode(-1);
		ListNode dummy = small;
		ListNode largeDummy = large;
		while (null != head) {
			if (head.val < x) {
				small.next = new ListNode(head.val);
				small = small.next;
			} else {
				large.next = new ListNode(head.val);
				large = large.next;
			}

			head = head.next;
		}

		small.next = largeDummy.next;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(2);
		p1.next = new ListNode(1);

		partition(p1, 2);
	}
}
