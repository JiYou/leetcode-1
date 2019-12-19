package leetcode;

import com.leetcode.common.TreeNode;

import java.util.Stack;

public class _536_Str2tree {
	public TreeNode str2Tree(String s) {
		if (s == null || s.length() < 1)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			char c = s.charAt(i);
			if (c == ')')
				stack.pop();
			else if (c >= '0' && c <= '9' || c =='-'){
				while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
					i++;
				TreeNode cur = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
				if (!stack.isEmpty()) {
					TreeNode parent = stack.peek();
					if (parent.left == null)
						parent.left = cur;
					else
						parent.right = cur;
				}
				stack.push(cur);
			}
		}
		return stack.peek();
	}

}
