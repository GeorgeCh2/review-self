/**
 * 移动零
 * @author georgechou
 * @link https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length, left = 0, right = 0;
        // 双指针
        while (right < length) {
            if (0 != nums[right]) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}