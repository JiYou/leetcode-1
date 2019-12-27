package leetcode;

public class _426_ConvertBSTToSortedDoublyLinkedList {

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}
		public Node(int _val, Node _left, Node _right) {
			this.val = _val;
			this.left = _left;
			this.right = _right;
		}
	}

	private Node pre = null;

	public Node BSTToDoublyList(Node node) {
		if (node == null)
			return null;
		Node dummy = new Node(0, null, node);
		pre = dummy;
		helper(node);
		pre.right = dummy.right;
		dummy.right.left = pre;
		return dummy.right;
	}

	private void helper(Node node) {
		if (node == null)
			return;
		helper(node.left);
		pre.right = node;
		node.left = pre;
		pre = node;
		helper(node.right);
	}


	private Node first = null;
	private Node last = null;

	public Node BSTToDoublyList2(Node node) {
		if(node == null)
			return node;
		helper2(node);
		last.right = first;
		first.left = last;
		return first;
	}

	private void helper2(Node node) {
		if (node == null)
			return;

		helper2(node.left);

		if (last != null) {
			last.right = node;
			node.left = last;
		} else
			first = node;
		last = node;

		helper2(node.right);
	}

}

