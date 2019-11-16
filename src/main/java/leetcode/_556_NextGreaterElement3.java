package leetcode;

public class _556_NextGreaterElement3 {
	public int nextGreaterElements(int n) {
		char[] res = (n + "").toCharArray();
		int i = res.length - 2;
		while (i >= 0 && res[i + 1] <= res[i])
			i--;
		if (i < 0)
			return -1;
		int j = res.length - 1;
		while (j > i && res[j] <= res[i])
			j--;
		swap(res, i, j);
		reverse(res, i + 1);
		return Integer.valueOf(res.toString());
	}


	private void reverse(char[] chars, int start) {
		int i = start, j = chars.length - 1;
		while (i < j)
			swap(chars, i++, j--);
	}

	private void swap(char[] chars, int i, int j) {
		char tmp = chars[i];
		chars[i] = chars[j];
		chars[j] = tmp;
	}
}
