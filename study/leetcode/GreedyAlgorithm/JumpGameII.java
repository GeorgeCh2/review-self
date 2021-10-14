/**
 * 跳跃游戏 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int jump = 0, end = 0, fast = 0;
		for (int i = 0; i < nums.length - 1 && end < nums.length - 1; i ++) {
			// 找到后面选择中可以跳到最远的位置
			fast = Math.max(nums[i] + i, fast);
			if (i == end) {
				jump++;
				// 更新下一跳的位置
				end = fast;
			}
		}

		return jump;
	}

}
