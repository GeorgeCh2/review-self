import java.util.*;

/**
 * 子集
 * @author georgechou
 * @link https://leetcode-cn.com/problems/subsets/
 */
public class SubsetsII {
	private List<List<Integer>> res = new ArrayList<>();
	private List<Integer> dummy = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(false, nums, 0);
		return res;
	}

	private void dfs(boolean choosePre, int[] nums, int i) {
		if (i == nums.length) {
			res.add(new ArrayList<>(dummy));
			return;
		}

		dfs(false, nums, i + 1);
		if (!choosePre && i > 0 && nums[i - 1] == nums[i]) {
			return;
		}
		dummy.add(nums[i]);
		dfs(true, nums, i + 1);
		dummy.remove(dummy.size() - 1);
	}
}
