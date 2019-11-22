package leetcode;

import java.util.Arrays;

class Solution {
	public int solution(int[] A) {
		if (A.length == 3)
			return A[0] * A[1] * A[2];
		Arrays.sort(A);
		int max = 1;

		int[] arr = new int[] {A[0], A[1], A[A.length - 1], A[A.length - 2]};



		return max;
	}
}
