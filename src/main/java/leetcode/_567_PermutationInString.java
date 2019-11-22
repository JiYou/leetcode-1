package leetcode;

public class _567_PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		int[] hash = new int[26];

		for (int i = 0; i < s1.length(); i++)
			hash[arr1[i] - 'a']++;

		int l = 0, count = 0;

		for (int r = 0; r < arr2.length; r++) {
			hash[arr2[r] - 'a']--;

			if (hash[arr2[r] - 'a'] >= 0)
				count++;

			if (r >= arr1.length) {
				hash[arr2[l] - 'a']++;
				if (hash[arr2[l] - 'a'] >= 1)
					count--;
				l++;
			}

			if (count == arr1.length)
				return true;
		}
		return false;
	}
}
