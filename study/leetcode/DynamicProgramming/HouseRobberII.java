/**
 * 打家劫舍 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/house-robber-ii/submissions/
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		int length = nums.length;
		if (1 == length) {
			return nums[0];
		} else if (2 == length) {
			return Math.max(nums[0], nums[1]);
		} else {
			return Math.max(dp(nums, 0, length - 2), dp(nums, 1, length - 1));
		}
	}

	private int dp(int[] nums, int start, int end) {
		int first = nums[start], second = Math.max(nums[start], nums[start + 1]), rob = second;

		// dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1])
		for (int i = start + 2; i <= end; i++) {
			rob = Math.max(nums[i] + first, second);
			first = second;
			second = rob;
		}

		return rob;
	}
}
