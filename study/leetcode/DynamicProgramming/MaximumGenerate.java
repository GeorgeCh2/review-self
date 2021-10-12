/**
 * 获取生成数组中的最大值
 * @author georgechou
 * @link https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class MaximumGenerate {
	public int getMaximumGenerated(int n) {
		if (0 == n) {
			return 0;
		}

		int[] num = new int[n+1];
		num[1] = 1;
		int max = 1;
		for (int i = 2; i <= n; i++) {
			num[i] = 0 == i%2 ? num[i/2] : num[i/2] + num[(i/2)+1];
			max = Math.max(max, num[i]);
		}

		return max;
	}
}
