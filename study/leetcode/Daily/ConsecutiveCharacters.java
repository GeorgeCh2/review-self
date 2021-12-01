/**
 * 连续字符
 * @author georgechou
 * @link https://leetcode-cn.com/problems/consecutive-characters/
 */
public class ConsecutiveCharacters {
	public int maxPower(String s) {
		int maxCount = 1, charCount = 1;
		// 一次遍历
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				charCount++;
				maxCount = Math.max(charCount, maxCount);
			} else {
				charCount = 1;
			}
		}

		return maxCount;
	}
}
