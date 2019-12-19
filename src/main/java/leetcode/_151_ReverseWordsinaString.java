package leetcode;

public class _151_ReverseWordsinaString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return null;
		char[] ch = s.toCharArray();
		reverse(ch, 0, s.length() - 1);
		reverseWord(ch, s.length());
		return cleanSpaces(ch, s.length());
	}

	private void reverse(char[] ch, int i, int j) {
		while(i < j) {
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
			i++;
			i--;
		}
	}

	private void reverseWord(char[] ch, int len) {
		int i = 0, j = 0;
		while (i < len) {
			while (i < j || i < len && ch[i] == ' ') i++;
			while (j < i || j < len && ch[j] != ' ') j++;
			reverse(ch, i, j - 1);
		}
	}

	private String cleanSpaces(char[] ch, int len) {
		int i = 0;
		int j = 0;
		while (j < len && ch[j] == ' ') j++;
		while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
		while (j < len && ch[j] == ' ') j++;
		if (j < len) ch[i++] = ' ';
		return ch.toString().substring(0, i);
	}

}
