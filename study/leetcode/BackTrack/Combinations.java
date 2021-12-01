import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @author georgechou
 * @link https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		backtrack(new ArrayList<>(), 1, n, k);

		return res;
	}

	private void backtrack(List<Integer> tracks, Integer cur, int n, int k) {
		// 剩余的数无法满足组合要求
		if (n - cur + tracks.size() < k - 1) {
			return;
		}

		if (k == tracks.size()) {
			res.add(new ArrayList<>(tracks));
			return;
		}

		for (Integer i = cur; i <= n; i++) {
			tracks.add(i);

			backtrack(tracks, i + 1, n, k);

			tracks.remove(i);
		}
	}
}
