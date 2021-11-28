/**
 * 合并二叉树
 * @author georgechou
 * @link https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeBinaryTrees {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (null == root1) {
			return root2;
		}

		if (null == root2) {
			return root1;
		}

		TreeNode node = new TreeNode(root1.val + root2.val);
		node.left = mergeTrees(root1.left, root2.left);
		node.right = mergeTrees(root1.right, root2.right);

		return node;
	}
}
