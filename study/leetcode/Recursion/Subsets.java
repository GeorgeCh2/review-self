import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author georgechou
 * @link https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {
	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(new ArrayList<>(), nums, 0);
		return res;
	}

	private void dfs(List<Integer> dummy, int[] nums, int i) {
		res.add(new ArrayList<>(dummy));

		if (i >= nums.length) {
			return;
		}

		for (; i < nums.length; i++) {
			dummy.add(nums[i]);
			dfs(dummy, nums, i+1);
			dummy.remove(dummy.size() - 1);
		}
	}
}
