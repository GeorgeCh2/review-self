/**
 * 不同路径 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathII {
	public static int uniquePaths(int[][] obstacleGrid) {
		int maxRow = obstacleGrid.length, maxCol = obstacleGrid[0].length;
		int[][] paths = new int[maxRow][maxCol];

		// 边界位置如果存在障碍物，后面的位置则无法到达
		for (int row = 0; row < maxRow && 0 == obstacleGrid[row][0]; row++) {
			paths[row][0] = 1;
		}
		for (int col = 0; col < maxCol && 0 == obstacleGrid[0][col]; col++) {
			paths[0][col] = 1;
		}

		for (int row = 1; row < obstacleGrid.length; row ++) {
			for (int col = 1; col < obstacleGrid[0].length; col++) {
				if (0 == obstacleGrid[row][col]) {
					paths[row][col] = paths[row][col-1] + paths[row-1][col];
				}
			}
		}

		return paths[obstacleGrid.length-1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		uniquePaths(new int[][]{{1,0,0}});
	}
}
