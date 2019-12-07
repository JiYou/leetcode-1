package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _939_MinAreaRect {
	public int minAreaRect(int[][] points) {
		HashMap<Integer, Map<Integer, int[]>> xymap = new HashMap<>();
		for (int[] point : points) {
			Map<Integer, int[]> map = xymap.get(point[0]);
			if (map == null) {
				map = new HashMap<>();
				xymap.put(point[0], map);
			}
			map.put(point[1], point);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++)
			for (int j = i + 1; j < points.length; j++) {
				if (points[i][0] == points[j][0] || points[i][1] == points[j][1])
					continue;
				if (xymap.get(points[i][0]).containsKey(points[j][1])
				&& xymap.get(points[j][0]).containsKey(points[i][1]))
					min = Math.min(min, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
			}
		return min;
	}
}
