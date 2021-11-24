public class ReverseStringII {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0, length = s.length();
        while(i < length) {
            int reverseStart = i;

            // 找到 空格 的位置
            while(i < length && ' ' != s.charAt(i)) {
                i++;
            }

            for (int index = i-1; index >= reverseStart; index--) {
                builder.append(s.charAt(index));
            }

            while(i < length && ' ' == s.charAt(i)) {
                builder.append(" ");
                i++;
            }
        }

        return builder.toString();
    }
}