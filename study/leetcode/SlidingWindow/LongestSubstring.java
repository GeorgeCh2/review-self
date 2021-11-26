import java.util.HashSet;
import java.util.Set;

/**
 * 最长公共子串
 * @author georgechou
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, maxLength = 0;
		Set<Character> charSet = new HashSet<>();
		while (right <= s.length() - 1) {
			char c = s.charAt(right);
			if (charSet.contains(c)) {
				// 缩小滑动窗口
				while (left <= right) {
					char leftChar = s.charAt(left);
					charSet.remove(leftChar);
					left++;
					if (c == leftChar) {
						break;
					}
				}
			}

			charSet.add(c);
			maxLength = Math.max(maxLength, charSet.size());
			right++;
		}

		return maxLength;
	}
}