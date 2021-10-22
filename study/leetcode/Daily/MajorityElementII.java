import java.util.*;

/**
 * 求众数 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/majority-element-ii/
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		Map<Integer, Integer> elementTimes = new HashMap<>();

		for (int num : nums) {
			elementTimes.merge(num, 1, Integer::sum);
		}

		List<Integer> res = new ArrayList<>();
		for (Integer element : elementTimes.keySet()) {
			if (elementTimes.get(element) > (nums.length / 3)) {
				res.add(element);
			}
		}

		return res;
	}
}
