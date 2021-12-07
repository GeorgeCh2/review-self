/**
 * 寻找旋转排序数组中的最小值
 * @author georgechou
 * @link https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinRotateArray {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1, minNum = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;

			// 0 ~ mid 有序
			if (nums[0] < nums[mid] || 0 == mid) {
				minNum = Math.min(nums[0], minNum);
				left = mid + 1;
			} else {
				// mid ~ length - 1 有序
				minNum = Math.min(nums[mid], minNum);
				right = mid - 1;
			}
		}

		return minNum;
	}
}
