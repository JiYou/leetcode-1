package leetcode;

import com.leetcode.common.TreeNode;

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {

	int pInorder;
	int pPostorder;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		pInorder = inorder.length - 1;
		pPostorder = postorder.length - 1;
		return helper(inorder, postorder, null);
	}


	public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
		if (pPostorder < 0)
			return null;
		TreeNode root = new TreeNode(postorder[pPostorder--]);
		if (inorder[pInorder] != root.value) {
			root.right = helper(inorder, postorder, root);
		}
		pInorder--;
		if (end == null || inorder[pInorder] != end.value)
			root.left = helper(inorder, postorder, end);
		return root;
	}

	private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
	                           int[] postorder, int postLeft, int postRight) {
		if (inorder == null || postorder == null || inLeft > inRight || postLeft > postRight)
			return null;

	  TreeNode root = new TreeNode(postorder[postRight]);
		int index = inLeft;
		while (inorder[index] != root.value)
			index++;

		root.left = buildTree(inorder, inLeft, index - 1, postorder, postLeft, postRight - inRight + index - 1);
		root.right = buildTree(inorder, index + 1, inRight, postorder, postRight - inRight + index, postRight - 1);
		return root;
	}
}
