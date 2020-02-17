package leetcode;

public class _845_LongestMountain {
	public int longestMountain(int[] A) {
		int n = A.length;
		int res = 0, begin = 0, end = 0;

		while (end < n) {
			end = begin;
			if (end + 1 < n && A[end] < A[end + 1]) {
				while (end + 1 < n && A[end] < A[end + 1])
					end++;
				if (end + 1 < n && A[end] > A[end + 1]) {
					while (end + 1 < n && A[end] > A[end + 1])
						end++;
					res = Math.max(res, end - begin + 1);
				}
			}
			begin = Math.max(end, end - begin + 1);
		}
		return res;
	}
}
