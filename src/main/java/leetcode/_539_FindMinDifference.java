package leetcode;

import java.util.List;

public class _539_FindMinDifference {
	public int findMinDifference(List<String> timePoints) {
		if (timePoints.size() > 1440)
			return 0;
		int[] hash = new int[1440];
		for (int i = 0; i < timePoints.size(); i++) {
			String time = timePoints.get(i);
			int min = Integer.valueOf(time.substring(0,2)) * 60 + Integer.valueOf(time.substring(3));
			if (hash[min] >= 1)
				return 0;
			hash[min]++;
		}

		int min = 1440, pre = -1, first = -1;
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 1) {
				if (pre != -1)
					min = Math.min(min, i - pre);
				else
					first = i;
				pre = i;
			}
		}
		min = Math.min(min, 1440 - pre +  first);
		return min;
	}
}
