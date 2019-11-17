package leetcode;

public class _245_ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int res = words.length;
		int a = -1, b = -1;

		for (int i = 0; i < words.length; i++) {
			if (words[i] == word1)
				a = i;
			if (words[i] == word2) {
				if (word1 == word2)
					a = b;
				b = i;
			}
			if (a != -1 && b != -1)
				res = Math.min(res, Math.abs(b - a));
		}
		return res;
	}
}
