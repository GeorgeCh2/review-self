/**
 * 两两交换链表中的节点
 * @author georgechou
 * @link https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodes {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode temp = dummy;
		while (null != temp.next && null != temp.next.next) {
			ListNode p1 = temp.next;
			ListNode p2 = temp.next.next;
			temp.next = p2;
			p1.next = p2.next;
			p2.next = p1;

			temp = p2;
		}

		return dummy.next;
	}
}
