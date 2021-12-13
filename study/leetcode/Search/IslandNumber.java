package life.codecook.leetcode.medium;

/**
 * 岛屿数量
 * @author georgechou
 * @link https://leetcode-cn.com/problems/number-of-islands/
 */
public class IslandNumber {
	public int numIslands(char[][] grid) {
		int islandNum = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if ('1' == grid[i][j]) {
					islandNum++;
					dfs(grid, i, j);
				}
			}
		}

		return islandNum;
	}

	/**
	 * 深度优先搜索
	 */
	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || '0' == grid[i][j]) {
			return;
		}

		grid[i][j] = '0';
		// 上
		dfs(grid, i - 1, j);
		// 下
		dfs(grid, i + 1, j);
		// 左
		dfs(grid, i, j - 1);
		// 右
		dfs(grid, i, j + 1);
	}
}
