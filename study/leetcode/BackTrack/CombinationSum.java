import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数
 * @author georgechou
 * @link https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {
	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		if (candidates[0] > target) {
			return res;
		}

		dfs(new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void dfs(List<Integer> dummy, int[] candidates, int target, int lastNum) {
		if (0 == target) {
			res.add(new ArrayList<>(dummy));
			return;
		}

		for (int candidate : candidates) {
			if (candidate > target) {
				return;
			}

			if (candidate < lastNum) {
				continue;
			}

			dummy.add(candidate);
			dfs(dummy, candidates, target - candidate, candidate);
			dummy.remove(dummy.size() - 1);
		}
	}
}
