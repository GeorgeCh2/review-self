/**
 * 解码方法
 * @author georgechou
 * @link https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {
	public int numDecodings(String s) {
		// ways[s.length()+1] 代表所有的解码方法
		int[] ways = new int[s.length()+1];
		ways[0] = 1;

		// ways[i] = ways[i-1] (使用一个数字)
		// ways[i] = ways[i-2] (使用2个数字)
		char[] chars = s.toCharArray();
		for (int i = 1; i < s.length()+1; i++) {
			// 使用1个数字
			if ('0' != chars[i-1]) {
				ways[i] += ways[i-1];
			}

			// 组合2个数字
			if (i > 1 && '0' != chars[i-2] && ((chars[i-2] - '0') * 10 + (chars[i-1] - '0') <= 26)) {
				ways[i] += ways[i-2];
			}
		}

		return ways[s.length()];
	}
}
