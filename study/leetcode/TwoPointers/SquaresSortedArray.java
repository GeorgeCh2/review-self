/**
 * 有序数组的平方
 * @author georgechou
 * @link https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        // 双指针
        for (int i = 0, j = nums.length - 1, pos = nums.length -1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                i++;
            } else {
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }

        return ans;
    }
}