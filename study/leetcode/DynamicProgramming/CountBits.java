/**
 * 比特位计数
 * @author georgechou
 * @link https://leetcode-cn.com/problems/counting-bits/
 */
public class CountBits {
	public int[] countBits(int n) {
		int[] res = new int[n+1];

		int dp = 0;
		for (int i = 1; i <= n; i++) {
			if (0 == (i & (i-1))) {
				dp = i;
			}

			res[i] = 1 + res[i-dp];
		}

		return res;
	}
}
