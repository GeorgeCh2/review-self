/**
 * 轮转数组
 * @author georgechou
 * @link https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k + 1, nums.length - 1);
    }

    /**
     * 数组翻转
     */
    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}