package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _658_FindClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		if (arr == null || arr.length == 0 || k == 0)
			return res;

		int l = 0, r = arr.length - k;

		while (l < r) {
			int mid = (r - l) / 2 + l;
			if (x - arr[mid] > arr[mid + k] - x)
				l = mid + 1;
			else
				r = mid;
		}

		for (int i = l; i < l + k; i++)
			res.add(arr[i]);
		return res;
	}
}
