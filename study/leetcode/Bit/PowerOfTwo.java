/**
 * 2 的幂
 * @author georgechou
 * @link https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n&(n - 1)) == 0;
    }
}