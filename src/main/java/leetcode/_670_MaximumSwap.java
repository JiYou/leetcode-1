package leetcode;

public class _670_MaximumSwap {
	public int maximumSwap(int num) {
		String s = String.valueOf(num);
		char[] arr = s.toCharArray();
		int[] back = new int[s.length()];
		for (int i = s.length() - 2; i >= 0; i--)
			back[i] = Math.max(s.charAt(i) - '0', s.charAt(i + 1) - '0');
		for (int i = 0; i < s.length(); i++) {
			if (arr[i] - '0' == back[i])
				continue;
			for (int j = back.length - 1;j > i; j--) {
				if (arr[j] - '0' == back[i]) {
					char tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		return Integer.valueOf(arr.toString());
	}
}
