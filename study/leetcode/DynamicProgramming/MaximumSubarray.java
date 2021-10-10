/**
 * 最大子序和
 * @author georgechou
 * @link https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int pre = 0, maxNum = nums[0];
		for (int num : nums) {
			pre = Math.max(num, pre + num);
			maxNum = Math.max(maxNum, pre);
		}

		return maxNum;
	}
}