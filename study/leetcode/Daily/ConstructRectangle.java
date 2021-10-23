/**
 * 构造矩形
 * @author georgechou
 * @link https://leetcode-cn.com/problems/construct-the-rectangle/
 */
public class ConstructRectangle {
	public int[] constructRectangle(int area) {
		/**
		 * l * w = area; w <= l;
		 * w * w <= l * w = area;
		 * w <= sqrt(area)
		 */
		int w = (int) Math.sqrt(area);
		while (0 != (area % w)) {
			w -= 1;
		}

		return new int[]{area / w, w};
	}
}
