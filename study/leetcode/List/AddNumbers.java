/**
 * 两数相加
 * @author georgechou
 * @link https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;

		// 记录进位
		int carry = 0;
		while (null != l1 || null != l2) {
			int temp = (null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + carry;
			if (temp >= 10) {
				carry = 1;
				temp -= 10;
			} else {
				carry = 0;
			}
			p.next = new ListNode(temp);
			p = p.next;
			l1 = null == l1 ? null : l1.next;
			l2 = null == l2 ? null : l2.next;
		}

		if (1 == carry) {
			p.next = new ListNode(carry);
		}

		return dummy.next;
	}
}
