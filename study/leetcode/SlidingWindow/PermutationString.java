/**
 * 字符串的排列
 * @author georgechou
 * @link https://leetcode-cn.com/problems/permutation-in-string/
 */
public class PermutationString {
	public boolean checkInclusion(String s1, String s2) {
		int s1Length = s1.length(), s2Length = s2.length();
		if (s2Length < s1Length) {
			return false;
		}

		// 初始化字符数量
		int[] charCount = new int[26];
		for (int i = 0; i < s1Length; i++) {
			charCount[s1.charAt(i) - 'a']--;
		}

		int left = 0, right = 0;
		while (right < s2Length) {
			int x = s2.charAt(right) - 'a';
			charCount[x]++;

			while (charCount[x] > 0) {
				charCount[s2.charAt(left) - 'a']--;
				left++;
			}

			right++;
			if (right - left== s1Length) {
				return true;
			}
		}

		return false;
	}
}