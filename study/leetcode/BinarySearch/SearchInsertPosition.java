/**
 * 搜索插入位置
 * @author georgechou
 * @link https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsertPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}