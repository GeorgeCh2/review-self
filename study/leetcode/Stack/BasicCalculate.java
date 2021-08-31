import java.util.Stack;

/**
 * 基本计算器
 * @author georgechou
 */
public class BasicCalculator {
	public int calculate(String s) {
		// 栈顶记录当前符号（1:+, -1:-）
		Stack<Integer> ops = new Stack<>();
		ops.push(1);

		int res = 0, num = 0, op = 1;
		for (char charParam : s.toCharArray()) {
			if (charParam > '0' && charParam < '9') {
				num = num * 10 + (charParam - '0');
				continue;
			}

			res += op * num;
			num = 0;

			switch (charParam) {
			case '+':
				op = ops.peek();
				break;
			case '-':
				op = -ops.peek();
				break;
			case '(':
				ops.push(op);
				break;
			case ')':
				ops.pop();
				break;
			default:
				break;
			}
		}

		res += num;
		return res;
	}

	public static void main(String[] args) {
		BasicCalculator calculator = new BasicCalculator();
		System.out.println(calculator.calculate("-2+1"));
	}
}
