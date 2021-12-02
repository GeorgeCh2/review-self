import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * @author georgechou
 * @link https://leetcode-cn.com/problems/triangle/submissions/
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n + 1];

		// 从底到顶
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
			}
		}

		return dp[0];
	}

	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		triangle.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3,4), Arrays.asList(6,5,7), Arrays.asList(4,1,8,3)));
	}
}
