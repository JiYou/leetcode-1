package leetcode;

import com.leetcode.common.TreeNode;

public class _108_sortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return nums == null ? null : buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int l, int r) {
		if(l > r)
			return null;
		int mid = (r - l) / 2 + l;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, l, mid - 1);
		root.right = buildTree(nums, mid + 1, r);
		return root;
	}
}
