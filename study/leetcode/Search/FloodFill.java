/**
 * 图像渲染
 * @author georgechou
 * @link https://leetcode-cn.com/problems/flood-fill/
 */
public class FloodFill {
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int currentColor = image[sr][sc];
		if (currentColor == newColor) {
			return image;
		}

		image[sr][sc] = newColor;
		dfs(image, sr, sc, newColor, currentColor);

		return image;
	}

	/**
	 * 深度优先遍历
	 */
	private void dfs(int[][] image, int sr, int sc, int newColor, int currentColor) {
		for (int i = 0; i < 4; i++) {
			int mx = sr + dx[i], my = sc + dy[i];
			if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length && currentColor == image[mx][my]) {
				image[mx][my] = newColor;
				dfs(image, mx, my, newColor, currentColor);
			}
		}
	}
}
