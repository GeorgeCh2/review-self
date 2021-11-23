/**
 * 两数之和II-输入有序数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
    public int[] twosum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        // 双指针
        while (low < high) {
            int temp = nums[low] + nums[high];
            if (target == temp) {
                return new int[]{low+1, high+1};
            } else if (target < temp) {
                high--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}