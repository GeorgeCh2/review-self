/**
 * @author georgechou
 * @link https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
			return head;
		}

        // 记录下各个节点
		List<ListNode> nodeList = new ArrayList<>();
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		while (null != dummy.next) {
			dummy = dummy.next;
			nodeList.add(dummy);
		}

        // 修改指向
		if (0 != k % nodeList.size()) {
			int index = k % nodeList.size();
			head = nodeList.get(nodeList.size() - index);
			nodeList.get(nodeList.size() - 1).next = nodeList.get(0);
			nodeList.get(nodeList.size() - index - 1).next = null;
		}

		return head;
    }
}