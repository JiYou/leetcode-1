package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _545_BoundaryOfBinaryTree {

	List<Integer> res = new ArrayList<>();
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null)
			return res;
		leftBoundary(root);
		leaves(root.left);
		leaves(root.right);
		rightBoundary(root);
		return res;
	}

	public void leftBoundary(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return;
		res.add(root.value);
		if (root.left == null)
			leftBoundary(root.right);
		else
			leftBoundary(root.left);
	}

	public void rightBoundary(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return;
		if (root.right == null)
			rightBoundary(root.left);
		else
			rightBoundary(root.right);
		res.add(root.value);
	}

	public void leaves(TreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			res.add(root.value);

		leaves(root.left);
		leaves(root.right);
	}


}
