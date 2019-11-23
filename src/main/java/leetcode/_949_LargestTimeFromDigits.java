package leetcode;

public class _949_LargestTimeFromDigits {

	int[] flags;
	String str = new String();
	String res = "0";
	public String largestTimeFromDigits(int[] A) {
		flags = new int[A.length];
		dfs(A, 0);
		return res.length() != 4 ? "" : (res.substring(0, 2) + ":" +
			res.substring(2));
	}

	private void dfs(int[] A, int step) {
		if(step == A.length) {
			if (Integer.parseInt(str.substring(2)) < 60)
				if (Integer.parseInt(str) >= Integer.parseInt(res))
					res = str;
			return;
		}

		for (int i = 0; i < A.length; i++) {
			if (flags[i] == 0) {
				if (str.length() == 1 && Integer.parseInt(str) > 2)
					continue;
				else if (str.length() == 2 && Integer.parseInt(str) >= 24)
					continue;

				flags[i] = 1;
				str += A[i];
				dfs(A, step + 1);
				flags[i] = 0;
				str = str.substring(0, str.length() - 1);
			}
		}
	}


}
