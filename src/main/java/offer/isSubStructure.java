package offer;

import com.leetcode.common.TreeNode;

public class isSubStructure {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}
	boolean recur(TreeNode A, TreeNode B) {
		if(B == null) return true;
		if(A == null || A.value != B.value) return false;
		return recur(A.left, B.left) && recur(A.right, B.right);
	}
}
