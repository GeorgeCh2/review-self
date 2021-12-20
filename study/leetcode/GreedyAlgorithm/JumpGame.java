/**
 * 跳跃游戏
 * @author georgechou
 * @link https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int farthest = 0, length = nums.length - 1;
		for (int i = 0; i <= length; i++) {
			if (i <= farthest) {
				// 计算可以跳的最远的位置
				farthest = Math.max(farthest, nums[i] + i);

				if (farthest >= length) {
					return true;
				}
			}
		}

		return false;
	}
}
