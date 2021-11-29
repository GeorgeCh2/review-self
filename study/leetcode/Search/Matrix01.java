import java.util.LinkedList;
import java.util.Queue;

/**
 * 01矩阵
 * @author georgechou
 * @link https://leetcode-cn.com/problems/01-matrix/
 */
public class Matrix01 {
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int[][] updateMatrix(int[][] mat) {
		int xLength = mat.length, yLength = mat[0].length;
		Queue<int[]> zeroQueue = new LinkedList<>();
		boolean[][] hasUpdate = new boolean[xLength][yLength];
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				if (0 == mat[x][y]) {
					zeroQueue.offer(new int[]{x, y});
					hasUpdate[x][y] = true;
				}
			}
		}

		while (!zeroQueue.isEmpty()) {
			int[] zeroPosition = zeroQueue.poll();
			int x = zeroPosition[0], y = zeroPosition[1];
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx >= 0 && mx < xLength && my >= 0 && my < yLength && !hasUpdate[mx][my]) {
					mat[mx][my] = mat[x][y] + 1;
					zeroQueue.offer(new int[]{mx, my});
					hasUpdate[mx][my] = true;
				}
			}
		}

		return mat;
	}
}
