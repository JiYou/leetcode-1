package leetcode;

public class _443_compressString {
	public int compress(char[] chars) {
		int left = 0, size = 0;

		for (int right = 0; right <= chars.length; right++) {
			if (right == chars.length || chars[right] != chars[left]) {
				chars[size++] = chars[left];
				if (right - left > 1) {
					for (char c : String.valueOf(right - left).toCharArray())
						chars[size++] = c;
				}
				left = right;
			}
		}
		return size;
	}
}
