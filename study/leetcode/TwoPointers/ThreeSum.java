import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author georgechou
 * @link https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		// 从小到大排序
		Arrays.sort(nums);

		int length = nums.length;
		for (int i = 0; i < length - 2; i++) {
			// 第一个数大于0，则后面不存在结果
			if (nums[i] > 0) {
				break;
			}

			// 去重
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1, right = length - 1;
			while (left < right) {
				int num = nums[i] + nums[left] + nums[right];
				if (0 == num) {
					// 满足要求
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// 去重
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					left++;
					right--;
				} else if (num > 0) {
					right--;
				} else {
					left++;
				}
			}
		}

		return res;
	}
}
