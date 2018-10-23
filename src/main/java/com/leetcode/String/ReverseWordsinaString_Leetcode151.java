package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/18.
 */
public class ReverseWordsinaString_Leetcode151 {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;
		StringBuffer sb = new StringBuffer();
		String[] words = s.trim().split("\\s+");
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}
		return sb.toString().trim();
	}

	public String reverseWords2(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] ch = s.toCharArray();
		reverse(ch, 0, s.length() - 1);
		reverseWords(ch, s.length());
		return cleanSpace(ch, s.length());
	}

	private void reverse(char[] ch, int i, int j) {
		while (i < j) {
			char tmp = ch[i];
			ch[i++] = ch[j];
			ch[j--] = tmp;
		}
	}

	private void reverseWords(char[] ch, int len) {
		int i = 0, j = 0;
		while (i < len) {
			while (i < j || i < len && ch[i] == ' ')
				i++;
			while (j < i || j < len && ch[j] != ' ')
				j++;
			reverse(ch, i, j - 1);
		}
	}

	private String cleanSpace(char[] ch, int len) {
		int i = 0, j = 0;
		while (j < len) {
			while (j < len && ch[j] == ' ') j++;
			while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
			if (j < len)
				ch[i++] = ' ';
		}
		return String.valueOf(ch).substring(0, i);
	}

}
