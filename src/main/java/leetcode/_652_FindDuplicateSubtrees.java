package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652_FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(root, res, new HashMap<>());
		return res;
	}

	private String helper(TreeNode node, List<TreeNode> res, Map<String,Integer> map) {
		if (node == null)
			return "#";
		String serial = helper(node.left, res, map) + "," + helper(node.right, res, map) + "," + node.value;

		if (map.getOrDefault(serial, 0) == 1){
			res.add(node);
		}
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}

}
