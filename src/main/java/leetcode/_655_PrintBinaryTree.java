package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _655_PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		int level = getHeight(root);
		int size = (int)Math.pow(2, level) - 1;
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < size; j++)
				list.add(" ");
			res.add(list);
		}
		helper(res, root, level, 0, size - 1);
		return res;
	}

	private void helper(List<List<String>> res, TreeNode node, int level, int left, int right) {
		if (node == null)
			return;
		int index = (left + right) / 2;
		res.get(level).set(index, node.value + "");
		helper(res, node.left, level + 1, left, index - 1);
		helper(res, node.right, level + 1, index + 1, right);
	}

	private int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return  Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
