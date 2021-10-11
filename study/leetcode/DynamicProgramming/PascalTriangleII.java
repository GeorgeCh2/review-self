import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * @author georgechou
 * @link https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i <= rowIndex; i++) {
			List<Integer> row = new ArrayList<>(i+1);
			for (int col = 0; col <= i; col++) {
				if (0 == col || i == col) {
					row.add(1);
				} else {
					row.add(dp.get(i-1).get(col-1) + dp.get(i-1).get(col));
				}
			}
			dp.add(row);
		}

		return dp.get(rowIndex);
	}
}
