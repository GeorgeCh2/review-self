/**
 * 亲密字符串
 * @author georgechou
 * @link https://leetcode-cn.com/problems/buddy-strings/
 */
public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            // 两个字符串相等，则需要保证存在相同的字符
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a'] += 1;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
        } else {
            int first = -1, second = -1;
            // 找到两个字符串中字符不一样的位置
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (-1 == first) {
                        first = i;
                    } else if (-1 == second) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return -1 != second && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        }
        return false;
    }
}