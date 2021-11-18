/**
 * 二叉树的坡度
 * @author georgechou
 * @link https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * 深度优先遍历
     */
    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);
        return root.val + left + right;
    }
}