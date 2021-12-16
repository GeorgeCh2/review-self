import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * @author georgechou
 * @link https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumberCombinations {
	private char[][] phoneLetter = new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
					{'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

	private List<String> res = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		digits = digits.trim();
		if (0 == digits.length()) {
			return new ArrayList<>();
		}

		backTrack(new StringBuilder(), digits);

		return res;
	}

	private void backTrack(StringBuilder dummy, String digits) {
		// 满足要求
		if (dummy.length() == digits.length()) {
			res.add(dummy.toString());
			return;
		}

		int num = digits.charAt(dummy.length()) - '0';
		for (char letter : phoneLetter[num - 2]) {
			dummy.append(letter);
			backTrack(dummy, digits);
			dummy.deleteCharAt(dummy.length() - 1);
		}
	}
}
