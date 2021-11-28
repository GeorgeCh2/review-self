/**
 * 填充每个节点的下一个右侧节点指针
 * @author georgechou
 * @link https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNode {
	public Node connect (Node root) {
		if (null == root) {
			return null;
		}

		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);

		while (!nodeQueue.isEmpty()) {
			int size = nodeQueue.size();
			for (int i = 0; i < size; i++) {
				Node node = nodeQueue.poll();

				if (i < size - 1) {
					node.next = nodeQueue.peek();
				}

				if (null != node.left) {
					nodeQueue.offer(node.left);
				}

				if (null != node.right) {
					nodeQueue.offer(node.right);
				}
			}
		}

		return root;
	}
}
