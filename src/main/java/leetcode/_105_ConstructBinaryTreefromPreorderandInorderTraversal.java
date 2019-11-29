package leetcode;

import com.leetcode.common.TreeNode;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);

		int index = 0;
		for (int i = inStart; i <= inEnd; i++)
			if (inorder[i] == root.value) {
				index = i;
				break;
			}
		root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
		root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
		return root;
	}

	private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight)
			return null;

		TreeNode root = new TreeNode(preorder[preLeft]);
		int index = inLeft;
		while (inorder[index] != root.value)
			index++;

		root.left = buildTree(preorder, preLeft + 1,
			preLeft + index - inLeft, inorder, inLeft, index - 1);
		root.right = buildTree(preorder, index - inLeft + preLeft + 1,
			preRight, inorder, index + 1, inRight);
		return root;
	}
}
