import java.util.Objects;
import java.util.Stack;

/**
 * Backspace String Compare
 * @author georgechou
 */
public class BackspaceCompare {

	public static boolean backspaceCompare(String s, String t) {
		Stack<Character> sStack = new Stack<>();
		Stack<Character> tStack = new Stack<>();
		for (char c : s.toCharArray()) {
			addVal(sStack, c);
		}

		for (char c : t.toCharArray()) {
			addVal(tStack, c);
		}

		while (!sStack.isEmpty() && !tStack.isEmpty()) {
			if (!Objects.equals(sStack.pop(), tStack.pop())) {
				return false;
			}
		}

		return sStack.isEmpty() && tStack.isEmpty();
	}

	private static void addVal(Stack<Character> stack, char val) {
		if ('#' == val) {
			if (!stack.isEmpty()) {
				stack.pop();
			}
		} else {
			stack.push(val);
		}
	}

	public static void main(String[] args) {
		System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}
}
