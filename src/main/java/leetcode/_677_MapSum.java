package leetcode;

public class _677_MapSum {

	class Node{
		Node[] children;
		int val;

		public Node() {
			children = new Node[26];
		}
	}


	Node root;
	public _677_MapSum() {
		root = new Node();
	}

	public void insert(String key, int val) {
		Node node = root;
		char[] arr = key.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i] - 'a';
			if (node.children[j] == null)
				node.children[j] = new Node();
			node = node.children[j];
		}
		node.val = val;
	}

	public int sum(String prefix) {
		if (prefix == null || prefix.length() == 0)
			return 0;
		char[] arr = prefix.toCharArray();
		for (int i = 0; i < prefix.length(); i++) {
			int j = arr[i] - 'a';
			if (root.children[j] == null)
				return 0;
			root = root.children[j];
		}
		return dfs(root);
	}

	private int dfs (Node node) {
		if (node == null)
			return 0;
		int res = node.val;
		for (Node no : node.children) {
			res += dfs(no);
		}
		return res;
	}
}
