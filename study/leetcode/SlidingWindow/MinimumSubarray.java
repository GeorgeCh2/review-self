/**
 * 长度最小的子数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSubarray {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0, sum = 0, minSize = Integer.MAX_VALUE, n = nums.length;
		while (right < n) {
			sum += nums[right];

			while (sum >= target) {
				minSize = Math.min(minSize, right - left + 1);
				sum -= nums[left];
				left++;
			}

			right++;
		}

		return minSize == Integer.MAX_VALUE ? 0 : minSize;
	}
}
