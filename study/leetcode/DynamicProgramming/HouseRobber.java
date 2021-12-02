/**
 * 打家劫舍
 * @author georgezhou
 * @link https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (1 == nums.length) {
			// 一间商店，则只打劫该商店
			return nums[0];
		}

		if (2 == nums.length) {
			// 两间商店，则打劫其中现金高的
			return Math.max(nums[0], nums[1]);
		}

		// dp[i] = max(dp[i-2] + nums[i], dp[i-1])
		int first = nums[0], second = Math.max(nums[0], nums[1]), rob = 0;
		for (int k = 2; k < nums.length; k++) {
			rob = Math.max(nums[k] + first, second);
			first = second;
			second = rob;
		}

		return rob;
	}
}
