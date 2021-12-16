import java.util.*;

/**
 * 组合总和 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		if (candidates[0] > target) {
			return res;
		}
		dfs(new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void dfs(List<Integer> dummy, int[] candidates, int target, int begin) {
		if (0 == target) {
			res.add(new ArrayList<>(dummy));
			return;
		}

		for (int i = begin; i < candidates.length; i++) {
			// 去掉重复选项
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}

			int candidate = candidates[i];
			if (candidate > target) {
				return;
			}
			dummy.add(candidate);
			dfs(dummy, candidates, target - candidate, i + 1);
			dummy.remove(dummy.size() - 1);
		}
	}
}
