/**
 * 爬楼梯
 * @author georgechou
 * @link https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		if (1 == n) {
			return 1;
		}

		if (2 == n) {
			return 2;
		}

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}
}
