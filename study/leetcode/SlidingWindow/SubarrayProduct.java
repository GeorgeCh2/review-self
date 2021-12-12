/**
 * 乘积小于K的子数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProduct {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int res = 0;
		int left = 0, right = 0, n = nums.length;
		while (left < n) {
			int temp = 1;
			while (right < n) {
				temp *= nums[right];
				if (temp >= k) {
					break;
				}
				res++;
				right++;
			}

			left++;
			right = left;
		}

		return res;
	}
}