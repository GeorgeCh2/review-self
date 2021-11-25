/**
 * 删除链表的倒数第 N 个结点
 * @author georgechou
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head, second = dummy.next;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while(first) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}