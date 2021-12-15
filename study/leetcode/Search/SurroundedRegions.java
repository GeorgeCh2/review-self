/**
 * 被围绕的区域
 * @author georgechou
 * @link https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
	private int m, n;

	public void solve(char[][] board) {
		m = board.length;
		n = board[0].length;

		// 左边界&右边界的 O 元素及相邻的 O 元素
		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}

		// 上边界&下边界的 O 元素及相邻的 O 元素
		for (int j = 1; j < n - 1; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);
		}

		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j++) {
				if ('O' == board[i][j]) {
					board[i][j] = 'X';
				} else if ('A' == board[i][j]) {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || 'O' != board[i][j]) {
			return;
		}

		board[i][j] = 'A';
		// 上
		dfs(board, i - 1, j);
		// 下
		dfs(board, i + 1, j);
		// 左
		dfs(board, i, j - 1);
		// 右
		dfs(board, i, j + 1);
	}
}
