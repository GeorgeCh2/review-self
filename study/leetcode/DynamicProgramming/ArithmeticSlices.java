/**
 * 等差数列划分
 * @author georgechou
 * @link https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] nums) {
		int length = nums.length;
		if (length < 3) {
			return 0;
		}

		int count = 0, d = nums[1] - nums[0], t = 0;
		for (int i = 2; i < nums.length; i++) {
			int num = nums[i] - nums[i - 1];
			if (num == d) {
				// 等差数列的个数
				t++;
			} else {
				d = num;
				t = 0;
			}
			count += t;
		}

		return count;
	}
}
