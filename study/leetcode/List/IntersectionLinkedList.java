/**
 * 相交链表
 * @author georgechou
 * @link https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA, p2 = headB;
		while (p1 != p2) {
			if (null == p1) {
				// 遍历完 A 链表后，开始遍历 B 链表
				p1 = headB;
			} else {
				p1 = p1.next;
			}

			if (null == p2) {
				// 遍历完 B 链表后，开始遍历 A 链表
				p2 = headA;
			} else {
				p2 = p2.next;
			}
		}

		return p1;
	}
}
