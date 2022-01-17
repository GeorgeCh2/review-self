import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @author georgechou
 * @link https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		// 排序
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		// 合并区间
		List<int[]> merged = new ArrayList<>();
		for (int[] interval : intervals) {
			if (0 == merged.size() || merged.get(merged.size() - 1)[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
			}
		}

		return merged.toArray(new int[0][]);
	}
}
