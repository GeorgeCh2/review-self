/**
 * 判断子序列
 * @author georgechou
 * @link https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int n = s.length(), m = t.length();

		int i = 0, j = 0;
		// 双指针
		while (i < n && j < m) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}

			j++;
		}

		return i == n;
	}
}
