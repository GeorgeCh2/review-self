/**
 * 第 N 个泰波那契数
 * @author georgechou
 * @link https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
class TribonacciNumber {
    public int tribonacci(int n) {
        if (0 == n) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        } 

        int p = 0, q = 1, r = 1, s = 0;
        for(int i = 3; i <= n; i++) {
            s = p + q + r;
            p = q;
            q = r;
            r = s;
        }

        return s;
    }
}