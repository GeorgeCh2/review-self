/**
 * 解码方法
 * @author georgechou
 * @link https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if ('0' == s.charAt(0)) {
			return 0;
		}

		int oneNumber = 1, twoNumber = 0, ans = 0;
		for (int i = 1; i < s.length()+1; i++) {
			ans = 0;
			// 使用1个数字
			if ('0' != s.charAt(i - 1)) {
				ans += oneNumber;
			}

			// 组合2个数字
			if (i > 1 && '0' != s.charAt(i - 2) && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
				ans += twoNumber;
			}
			twoNumber = oneNumber;
			oneNumber = ans;
		}

		return ans;
	}
}
