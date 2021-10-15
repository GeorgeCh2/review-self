/**
 * 不同路径
 * @author georgechou
 * @link https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePath {
	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];

		for (int row = 0; row < m; row ++) {
			for (int col = 0; col < n; col++) {
				if (0 == row || 0 == col) {
					paths[row][col] = 1;
				} else {
					paths[row][col] = paths[row][col-1] + paths[row-1][col];
				}
			}
		}

		return paths[m-1][n-1];
	}
}
