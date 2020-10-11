package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _297_SerializeandDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		if(root == null)
			return "";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append("null ");
				continue;
			}
			sb.append(cur.value + " ");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;
		String[] strs = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		for (int i = 1; i < strs.length; i++) {
			TreeNode cur = queue.poll();
			if (strs[i] != "null") {
				cur.left = new TreeNode(Integer.parseInt(strs[i]));
				queue.offer(cur.left);
			}
			if (strs[++i] != "null") {
				cur.right = new TreeNode(Integer.parseInt(strs[i + 1]));
				queue.offer(cur.right);
			}
		}
		return root;
	}
}
