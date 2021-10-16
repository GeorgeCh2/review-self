/**
 * 最小路径和
 * @author georgechou
 * @link https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int maxRow = grid.length, maxCol = grid[0].length;
		int[][] minPaths = new int[maxRow][maxCol];

		// 边界位置的最小路径和即为上一位置最小路径和 + 本位置路径
		minPaths[0][0] = grid[0][0];
		for (int row = 1; row < maxRow; row++) {
			minPaths[row][0] = grid[row][0] + minPaths[row-1][0];
		}
		for (int col = 1; col < maxCol; col++) {
			minPaths[0][col] = grid[0][col] + minPaths[0][col-1];
		}

		for (int row = 1; row < maxRow; row++) {
			for (int col = 1; col < maxCol; col++) {
				minPaths[row][col] = grid[row][col] + Math.min(minPaths[row][col-1], minPaths[row-1][col]);
			}
		}

		return minPaths[maxRow-1][maxCol-1];
	}
}
