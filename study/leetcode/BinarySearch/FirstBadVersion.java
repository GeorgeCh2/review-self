/**
 * 第一个错误的版本
 * @author georgechou
 * @link https://leetcode-cn.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}