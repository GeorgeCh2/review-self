import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * @author georgechou
 * @link https://leetcode-cn.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
		List<StringBuilder> ans = new ArrayList<>();
		ans.add(new StringBuilder());

		for (char c : s.toCharArray()) {
			int n = ans.size();
			if (Character.isLetter(c)) {
				for (int i = 0; i < n; i++) {
					ans.add(new StringBuilder(ans.get(i)));
					ans.get(i).append(Character.toLowerCase(c));
					ans.get(n+i).append(Character.toUpperCase(c));
				}
			} else {
				for (int i = 0; i < n; i++) {
					ans.get(i).append(c);
				}
			}
		}

		List<String> res = new ArrayList<>();
		for (StringBuilder an : ans) {
			res.add(an.toString());
		}

		return res;
	}
}
