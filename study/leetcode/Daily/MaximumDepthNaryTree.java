/**
 * N 叉树的最大深度
 * @author georgechou
 * @link https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthNaryTree {
    /**
     * 深度优先遍历
     */
    public int maxDepth(Node root) {
		if (null == root) {
			return 0;
		}

		if (null == root.children || root.children.size() == 0) {
			return 1;
		}

		int maxDepth = 0;
		for (Node children : root.children) {
			maxDepth = Math.max(maxDepth(children), maxDepth);
		}

		return maxDepth + 1;
	}
}