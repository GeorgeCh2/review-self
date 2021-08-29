import java.util.Stack;

/**
 * Valid Parentheses
 * @author georgechour
 */
public class ValidParentheses {
	public static boolean isValid(String s) {
		if (s.isEmpty()) {
			return true;
		}

		Stack<Character> rightStack = new Stack<>();
		for (char parenthesis : s.toCharArray()) {
			if ('(' == parenthesis) {
				rightStack.push(')');
			} else if ('{' == parenthesis) {
				rightStack.push('}');
			} else if ('[' == parenthesis) {
				rightStack.push(']');
			} else if (rightStack.isEmpty() || parenthesis != rightStack.pop()){
				return false;
			}
		}

		return rightStack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("{"));
	}
}