package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/18.
 */
public class ReverseWordsinaStringII_Leetcode186 {
	public void reverseWords(String s) {
		char[] ch = s.toCharArray();
		reverse(ch, 0, s.length() - 1);
		int r = 0;
		while (r < s.length()) {
			int l = r;
			while (r < s.length() && ch[r] != ' ')
				r++;
			reverse(ch, l, r - 1);
			r++;
		}
	}

	private void reverse(char[] ch, int i, int j) {
		while (i < j) {
			char tmp = ch[i];
			ch[i++] = ch[j];
			ch[j++] = tmp;
		}
	}
}
