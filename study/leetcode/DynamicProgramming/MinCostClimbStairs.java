/**
 * 使用最小花费爬楼梯
 * @author georgechou
 * @link https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbStairs {
	public int minCostClimbingStairs(int[] cost) {
		int prev = 0, curr = 0, out = 0;

		// 动态规划 - dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
		for (int i = 2; i <= cost.length; i++) {
			out = Math.min(prev + cost[i-1], curr + cost[i-2]);
			curr = prev;
			prev = out;
		}

		return out;
	}

}
