import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * @author georgechou
 * @link https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class AllAnagramsString {
	public List<Integer> findAnagrams(String s, String p) {
		int sLength = s.length(), pLength = p.length();
		if (sLength < pLength) {
			return new ArrayList<>();
		}

		int[] charCount = new int[26];
		for (char c : p.toCharArray()) {
			charCount[c - 'a']--;
		}

		int left = 0, right = 0;
		List<Integer> res = new ArrayList<>();
		int[] charCountTemp = Arrays.copyOf(charCount, charCount.length);
		while (left <= sLength - pLength) {
			int x = s.charAt(right) - 'a';
			charCountTemp[x]++;

			while (charCountTemp[x] > 0) {
				charCountTemp[s.charAt(left) - 'a']--;
				left++;
			}

			right++;
			if (right - left == pLength) {
				res.add(left);
				left++;
				right = left;
				charCountTemp = Arrays.copyOf(charCount, charCount.length);
			}
		}

		return res;
	}
}
