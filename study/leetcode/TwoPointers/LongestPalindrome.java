/**
 * 最长回文子串
 * @author georgechou
 * @link https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
	private int length;
	
	public String longestPalindrome(String s) {
		String res = "";
		length = s.length();
		for (int i = 0; i < length; i++) {
			// 回文串长度为奇数的情况
			String s1 = palindrome(s, i, i);
			// 回文串长度为偶数的情况
			String s2 = palindrome(s, i, i + 1);
			res = s1.length() > s2.length() ? (s1.length() > res.length() ? s1 : res) : (s2.length() > res.length() ? s2 : res);
		}

		return res;
	}

	// 中心扩散
	private String palindrome(String s, int l, int r) {
		while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		return s.substring(l+1, r);
	}
}
