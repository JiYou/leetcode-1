package leetcode;

public class _191_Numberof1Bits {
	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			n &= (n - 1);
			res++;
		}
		return res;
	}
}
