package leetcode;

public class _769_MaxChunksToSorted {
	public int maxChunksToSorted(int[] arr) {
		int res = 0;
		for (int i = 0, max = 0; i < arr.length; i++){
			max = Math.max(max, arr[i]);
			if (max == i)
				res++;
		}
		return res;
	}
}
