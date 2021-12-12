/**
 * 盛最多水的容器
 * @author georgechou
 * @link https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MostWaterContainer {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1, maxArea = 0;

		// 双指针
		while (left < right) {
			maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);

			// 移动值较小的指针
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
