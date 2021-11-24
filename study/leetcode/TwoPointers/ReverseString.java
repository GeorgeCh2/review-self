/**
 * 反转字符
 * @author georgechou
 * @link https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        // 双指针
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}