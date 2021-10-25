/**
 * 搜索二维矩阵
 * @author georgechou
 * @link https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length <= 0) {
			return false;
		}

		int col = 0, row = matrix[0].length - 1;
		// Z 字形遍历
		while (col < matrix.length && row >= 0) {
			if (target == matrix[col][row]) {
				return true;
			} else if (target > matrix[col][row]){
				col++;
			} else {
				row--;
			}
		}

		return false;
	}
}
