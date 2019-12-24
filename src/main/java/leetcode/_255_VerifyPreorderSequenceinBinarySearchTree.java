package leetcode;

import java.util.Stack;

public class _255_VerifyPreorderSequenceinBinarySearchTree {
	public static boolean verifyPreorder(int[] preorder) {
		int min = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();

		for (int num : preorder) {
			if (num < min)
				return false;
			while (!stack.isEmpty() && num > stack.peek())
				min = stack.pop();
			stack.push(num);
		}
		return true;
	}
}
