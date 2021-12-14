/**
 * 另一棵树的子树
 * @author georgechou
 * @link https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Subtree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return dfs(root, subRoot);
	}

	private boolean dfs(TreeNode root, TreeNode subRoot) {
		if (null == root) {
			return false;
		}

		return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
	}

	private boolean check(TreeNode root, TreeNode subRoot) {
		if (null == root && null == subRoot) {
			return true;
		}

		if (null == root || null == subRoot || root.val != subRoot.val) {
			return false;
		}

		return check(root.left, subRoot.left) && check(root.right, subRoot.right);
	}
}
