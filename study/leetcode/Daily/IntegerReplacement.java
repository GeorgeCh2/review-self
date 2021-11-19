/**
 * 整数替换
 * @author georgechou
 * @link https://leetcode-cn.com/problems/integer-replacement/
 */
public class IntegerReplacement() {
    private Map<Integer, Integer> dp = new HashMap<>();

    public int integerReplacement(int n) {
        if (1 == n) {
            return 0;
        }

        if (null != dp.get(n)) {
            return dp.get(n);
        }

        int rep = 0;
        if (0 == n%2) {
            rep += 1 + integerReplacement(n/2);
        } else if (1 == n%2) {
            rep += 2 + Math.min(integerReplacement(n/2 + 1), integerReplacement(n/2 - 1));
        }

        dp.put(n, rep);

        return rep;
    }
}