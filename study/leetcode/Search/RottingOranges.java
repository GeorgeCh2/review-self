import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * @author georgechou
 * @link https://leetcode-cn.com/problems/rotting-oranges/
 */
public class RottingOranges {
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int orangesRotting(int[][] grid) {
		int xLength = grid.length, yLength = grid[0].length, freshCount = 0;
		Queue<int[]> rottenPosition = new LinkedList<>();
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				if (2 == grid[x][y]) {
					rottenPosition.offer(new int[]{x, y});
				} else if (1 == grid[x][y]) {
					freshCount++;
				}
			}
		}

		// 没有新鲜的橘子
		if (0 == freshCount) {
			return 0;
		}

		int minutes = 0;
		while (freshCount > 0 && !rottenPosition.isEmpty()) {
			int size = rottenPosition.size();
			for (int round = 0; round < size; round++) {
				int[] position = rottenPosition.poll();
				int x = position[0], y = position[1];
				for (int i = 0; i < 4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					if (mx >= 0 && mx < xLength && my >= 0 && my < yLength && 1 == grid[mx][my]) {
						grid[mx][my] = 2;
						rottenPosition.offer(new int[]{mx, my});
						freshCount--;
					}
				}
			}
			minutes++;
		}

		return 0 == freshCount ? minutes : -1;
	}
}
