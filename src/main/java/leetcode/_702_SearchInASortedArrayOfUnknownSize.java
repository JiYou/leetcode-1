package leetcode;

public class _702_SearchInASortedArrayOfUnknownSize {
	public int search(ArrayReader reader, int target) {
		int left = 0, right = 10000;

		while (left <= right) {
			int mid = (right - left) / 2 + left;
			int tmid = reader.get(mid);
			if (tmid == 2147483647 || target < tmid)
				right = mid - 1;
			else if (target > tmid)
				left = mid + 1;
			else if (tmid == target)
				return mid;
		}
		return -1;
	}



	class ArrayReader {
		public int get(int n) {
			return -1;
		}
	}

}
