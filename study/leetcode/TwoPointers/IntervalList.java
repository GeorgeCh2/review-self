import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * @author georgechou
 * @link https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class IntervalList {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int firstLength = firstList.length, secondLength = secondList.length, i = 0, j = 0;
		List<int[]> nums = new ArrayList<>();
		while (i < firstLength && j < secondLength) {
			int first = Math.max(firstList[i][0], secondList[j][0]);
			int second = Math.min(firstList[i][1], secondList[j][1]);

			if (first <= second) {
				nums.add(new int[]{first, second});
			}

			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		return nums.toArray(new int[nums.size()][]);
	}
}
