/**
 * 岛屿的最大面积
 * @author georgechou
 * @linnk https://leetcode-cn.com/problems/max-area-of-island/
 */
public class MaxAreaIsland {
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				if (1 == grid[x][y]) {
					maxArea = Math.max(maxArea, dfs(grid, x, y));
				}
			}
		}

		return maxArea;
	}

	/**
	 * 深度优先搜索
	 * @param grid
	 * @param x
	 * @param y
	 * @return
	 */
	public int dfs(int[][] grid, int x, int y) {
		int area = 1;
		grid[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i], my = y + dy[i];
			if (mx >= 0 && mx < grid.length && my >= 0 && my < grid[0].length && grid[mx][my] == 1) {
				grid[x][y] = 0;
				area += dfs(grid, mx, my);
			}
		}

		return area;
	}
}
