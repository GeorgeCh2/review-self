/**
 * 最长回文子串
 * @author georgechou
 * @link https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
		String res = "";

		// 解决回文串的核心就是双指针
		for (int i = 0; i < s.length(); i++) {
			String str1 = palindrome(s, i, i);
			String str2 = palindrome(s, i, i + 1);

			res = str1.length() > res.length() ? str1 : res;
			res = str2.length() > res.length() ? str2 : res;
		}

		return res;
	}

	private String palindrome(String s, int l, int r) {
		char[] chars = s.toCharArray();
		while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
			l--;
			r++;
		}

		return s.substring(l+1, r);
	}
}
