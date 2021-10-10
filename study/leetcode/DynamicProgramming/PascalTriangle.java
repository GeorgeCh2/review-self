import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * @author georgechou
 * @link https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>(numRows);
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>(i+1);
			for (int col = 0; col < (i+1); col++) {
				if (0 == col || col == i) {
					row.add(1);
					continue;
				}
				row.add(res.get(i-1).get(col-1) + res.get(i-1).get(col));
			}
			res.add(i, row);
		}

		return res;
	}
}
