/**
 * 下一个排列
 * @author georgechou
 * @link https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int length = nums.length, i = length - 2;
		while (i >= 0 && nums[i] >= nums[i+1]) {
			i--;
		}

		if (i >= 0) {
			for (int j = length - 1; j > i; j--) {
				if (nums[j] > nums[i]) {
					swap(nums, i, j);
					break;
				}
			}
		}

		reverse(nums, i+1, length-1);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
