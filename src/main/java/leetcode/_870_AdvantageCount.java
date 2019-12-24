package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class _870_AdvantageCount {
	public int[] advantageCount(int[] A, int[] B) {
		Arrays.sort(A);
		LinkedList<Node> list = new LinkedList<>();
		for (int i = 0; i < B.length; i++)
			list.add(new Node(B[i], i));

		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.val - o2.val);
			}
		});

		for (int i = 0; i < A.length; i++) {
			if (A[i] > list.getFirst().val)
				B[list.removeFirst().index] = A[i];
			else
				B[list.removeLast().index] = A[i];
		}

		return B;
	}


	class Node {
		int val;
		int index;

		public Node(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}
