/**
 * 寻找峰值
 * @author georgechou
 * @link https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (right + left) / 2;

			// 峰值在左侧
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				// 峰值在右侧
				left = mid + 1;
			}
		}

		return left;
	}
}
