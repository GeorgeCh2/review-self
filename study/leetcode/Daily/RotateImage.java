/**
 * 旋转图像
 * @author georgechou
 * @link https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// 水平翻转
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = temp;
			}
		}

		// 对角线翻转
		for (int i = 0; i < n; i ++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
