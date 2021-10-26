import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大的元素
 * @author georgechou
 * @link https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];

		Map<Integer, Integer> elementIndex = new HashMap<>();
		Deque<Integer> stack = new ArrayDeque<>();
        // 倒序遍历
		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
				stack.pop();
			}

			elementIndex.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
			stack.push(nums2[i]);
		}

		for (int i = 0; i < nums1.length; i++) {
			res[i] = elementIndex.get(nums1[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
	}
}
