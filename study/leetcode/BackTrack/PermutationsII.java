import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationsII {
	private List<List<Integer>> res = new ArrayList<>();
	private List<Integer> dummy = new ArrayList<>();
	private boolean[] visited;

	public List<List<Integer>> permuteUnique(int[] nums) {
		visited = new boolean[nums.length];
		Arrays.sort(nums);
		backTrack(nums);
		return res;
	}

	private void backTrack(int[] nums) {
		if (dummy.size() == nums.length) {
			res.add(new ArrayList<>(dummy));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && visited[i-1] && nums[i] == nums[i - 1])) {
				continue;
			}

			visited[i] = true;
			dummy.add(nums[i]);
			backTrack(nums);
			dummy.remove(dummy.size() - 1);
			visited[i] = false;
		}
	}
}
