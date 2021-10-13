import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author georgechou
 * @link https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
	private List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		char[] track = new char[2*n];
		// 回溯算法
		backtrack(track, 0, 0, 0, n);
		return res;
	}

	private void backtrack(char[] track, int i, int left, int right, int n) {
		if (2*n == i) {
			res.add(String.valueOf(track));
			return;
		}

		// 先添加左括号
		if (left < n) {
			track[i] = '(';
			backtrack(track, i+1, left+1, right, n);
		}

		// 右括号比左括号少的情况下，可以放右括号
		if (right < left) {
			track[i] = ')';
			backtrack(track, i+1, left, right+1, n);
		}
	}
}
