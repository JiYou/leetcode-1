package leetcode;

import com.leetcode.common.TreeNode;

public class _333_LargestBSTSubtree {
	private int res = 0;
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		helper(root);
		return res;
	}

	private SearchNode helper(TreeNode node) {
		if(node == null)
			return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		SearchNode left = helper(node.left);
		SearchNode right = helper(node.right);
		if (left.size == -1 || right.size == -1 || node.value <= left.upper || node.value >= right.lower)
			return new SearchNode(-1,0,0);
		int size = left.size + right.size + 1;
		res = Math.max(res, size);
		return new SearchNode(size, Math.min(left.lower, node.value), Math.max(right.upper, node.value));
	}

	class SearchNode {
		int size;
		int lower;
		int upper;

		SearchNode(int size, int lower, int upper) {
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}

	int preVal = Integer.MIN_VALUE;

	public int largestBSTSubTree(TreeNode root) {
		if (root == null)
			return 0;
		if (isBST(root)) {
			res = Math.max(res, getCount(root));
		}
		largestBSTSubtree(root.left);
		largestBSTSubtree(root.right);
		return res;
	}

	private int getCount(TreeNode root) {
		if (root == null)
			return 0;
		return getCount(root.left) + getCount(root.right) + 1;
	}

	private boolean isBST(TreeNode root) {
		if (root == null)
			return true;
		boolean left = isBST(root.left);
		if (root.value <= preVal)
			return false;
		preVal = root.value;
		boolean right = isBST(root.right);
		return left && right;
	}
}
