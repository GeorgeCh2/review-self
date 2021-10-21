/**
 * @author georgechou
 * @link https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		for (int i = length - 1; i >= 0; i--) {
			int temp = digits[i] + 1;
			if (temp < 10) {
				digits[i] = temp;
				return digits;
			}

			digits[i] = 0;
		}

		// 只有每个数字是9，才会到达这里，直接初始化 length+1 长度的数组，首位置为1即可
		digits = new int[length+1];
		digits[0] = 1;

		return digits;
	}
}
