package leetcode;

public class _769_MaxChunksToSorted {
	public int maxChunksToSorted(int[] arr) {
		//核心思想也比较简单，因为是想尽量多地分割，只有当前i个数正好就是[0,1...i-1]的排列时，才能在i处多添加一个块。
		int res = 0;
		for (int i = 0, max = 0; i < arr.length; i++){
			max = Math.max(max, arr[i]);
			if (max == i)
				res++;
		}
		return res;
	}
}
