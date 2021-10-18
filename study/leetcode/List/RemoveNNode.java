/**
 * 删除链表的倒数第 N 个节点
 * @author georgechou
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 虚拟节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		// 找到倒数第 N+1 个节点
		ListNode nthNode = findNthNode(dummy, n+1);
		nthNode.next = nthNode.next.next;

		return dummy.next;
	}

	/**
	 * 找到倒数第 N 个节点
	 * @param head
	 * @param n
	 * @return
	 */
	private ListNode findNthNode(ListNode head, int n) {
		ListNode p = head;
		// p 指针先走 n 步
		for (int i = 0; i < n; i++) {
			p = p.next;
		}

		// k 指针从头开始走，p 指针走 length-n步到达终点，此时k指针指向倒数第 n 个节点
		ListNode k = head;
		while (null != p) {
			p = p.next;
			k = k.next;
		}

		return k;
	}
}
