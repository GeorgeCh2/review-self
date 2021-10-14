/**
 * 跳跃游戏
 * @author georgechou
 * @link https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			// 计算可以跳的最远的位置
			farthest = Math.max(farthest, nums[i] + i);

			// 遇到的选择为0，无法继续下一跳
			if (farthest <= i) {
				return false;
			}
		}

		return true;
	}
}
