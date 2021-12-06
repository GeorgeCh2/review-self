/**
 * 搜索旋转排序数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotateArray {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1, n = right;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[0] <= nums[mid]) {
				// 0 ~ mid 有序
				if (nums[mid] > target && nums[0] <= target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// mid ～ length 有序
				if (nums[mid] < target && target <= nums[n]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}
}
