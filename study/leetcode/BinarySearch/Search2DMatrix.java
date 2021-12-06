/**
 * 搜索二维矩阵
 * @author georgechou
 * @link https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// 找到所在行
		int x = binarySearchX(matrix, target);
		if (-1 == x) {
			return false;
		}

		// 是否存在该行
		return binarySearchY(matrix[x], target);
	}

	private int binarySearchX(int[][] matrix, int target) {
		int left = 0, right = matrix.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == matrix[mid][0]) {
				return mid;
			} else if(matrix[mid][0] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return (left >=0 && left < matrix.length && matrix[left][0] < target) ? left : left - 1;
	}

	private boolean binarySearchY(int[] matrix, int target) {
		int left = 0, right = matrix.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == matrix[mid]) {
				return true;
			} else if (matrix[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}
}
