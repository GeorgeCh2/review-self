/**
 * 位 1 的个数
 * @author georgechou
 * @link https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberBits {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }   

        return ret;
    }
}