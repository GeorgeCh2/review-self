import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permutations {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> tracks = new ArrayList<>(nums.length);
		backTrack(nums, tracks);
		return res;
	}

    /**
     * 回溯算法
     */
	private void backTrack(int[] nums, List<Integer> tracks) {
        // 满足要求
		if (tracks.size() == nums.length) {
			res.add(new ArrayList<>(tracks));
			return;
		}

		for (int num : nums) {
            // 排除不合法的选择
			if (tracks.contains(num)) {
				continue;
			}
            // 做选择
			tracks.add(num);
            // 进入下一层决策树
			backTrack(nums, tracks);
            // 取消选择
			tracks.remove(tracks.size() - 1);
		}
	}
}