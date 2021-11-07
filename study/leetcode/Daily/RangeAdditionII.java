/**
 * 范围求和 II
 * @author georgechou
 * @link https://leetcode.com/problems/range-addition-ii/
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;

        // 找出最小的x和y，即为累加最多的元素
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }
}