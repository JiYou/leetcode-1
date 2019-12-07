package leetcode;

import java.util.PriorityQueue;

public class _378_KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> queue = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
		for (int i = 0; i < matrix.length; i++)
			queue.offer(new Tuple(0, i, matrix[0][i]));
		for (int i = 0; i < k - 1; i++) {
			Tuple t = queue.poll();
			if (t.x == matrix.length - 1)
				continue;
			queue.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
		}
		return queue.poll().val;
	}

	class Tuple {
		int x, y, val;
		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public int kthSmallest2(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];
		while (left + 1 < right) {
			int mid = (right - left) / 2 + left;
			int num = count(matrix, mid);
			if(num >= k)
				right = mid;
			else
				left = mid;
		}
		if(count(matrix, right) <= k - 1)
			return right;
		return left;
	}

	private int count(int[][]matrix, int num) {
		int i = matrix.length - 1, j = 0;
		int res = 0;
		while (i >= 0 && j < matrix.length) {
			if (matrix[i][j] < num) {
				res += i + 1;
				j++;
			} else {
				i--;
			}
		}
		return res;
	}
}
