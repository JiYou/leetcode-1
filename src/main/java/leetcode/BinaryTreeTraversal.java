package leetcode;

import com.leetcode.common.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
	//对比代码， 前序遍历，唯一区别就是， 一个一直向左， 一个一直向右
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while(root != null || !stack.isEmpty()){
			//go left down to the ground
			while(root != null){
				res.add(root.value);
				stack.push(root);
				root = root.left;
			}

			//if we reach to the leaf, go back to the parent right, and repeat the go left down.
			TreeNode cur = stack.pop();
			root = cur.right;
		}
		return res;
	}

	public List < Integer > inorderTraversal(TreeNode root) {
		List < Integer > res = new ArrayList <> ();
		Stack < TreeNode > stack = new Stack <> ();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.value);
			root = root.right;
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while(root != null || !stack.isEmpty()){
			while(root != null){
				res.add(root.value);
				stack.push(root);
				root = root.right;
			}

			TreeNode cur = stack.pop();
			root = cur.left;
		}

		Collections.reverse(res);
		return res;
	}
}
