/**
 * 有效的完全平方数
 * @author georgezhou
 * @link https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		int left = 0, right = num;
		while (left <= right) {
			// 二分查找
			int mid = left + (right - left) / 2;
			long square = (long) mid * mid;
			if (square == num) {
				return true;
			} else if (square > num) {
	            right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}
}
