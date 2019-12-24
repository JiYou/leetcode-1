package leetcode;

public class _718_FindMaxLengthSubArray {

	public int findLength(int[] A, int[] B) {
		return A.length > B.length ? findMax(B, A) : findMax(A, B);
	}

	private int findMax(int[] A, int[] B) {
		int max = 0;
		int an = A.length, bn = B.length;

		for (int len = 1; len <= an; len++)
			max = Math.max(max, maxLen(A, 0, B, bn - len, len));

		for (int j = bn - an; j >=0; j--)
			max = Math.max(max, maxLen(A, 0, B, j, an));
		for (int i = 1; i <= an; i++)
			max = Math.max(max, maxLen(A, i, B, 0, an - i));
		return max;
	}


	private int maxLen(int[] a, int i, int[] b, int j, int len) {
		int count = 0, max = 0;

		for (int k =0; k < len; k++) {
			if (a[i + k] == b[j + k])
				count++;
			else if (count > 0){
				max = Math.max(count, max);
				count = 0;
			}
		}
		return max;
	}
}
