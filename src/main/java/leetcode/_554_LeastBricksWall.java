package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_LeastBricksWall {
	public int leastBricks(List<List<Integer>> wall) {
		int[] pos = new int[wall.size()];
		int sum = 0, count = 0, res = 0;

		while (sum > 0) {
			count = 0;
			for (int i = 0; i < wall.size(); i++) {
				List<Integer> row = wall.get(i);
				if (row.get(pos[i]) != 0)
					count++;
				else
					pos[i]++;
				row.set(pos[i], row.get(pos[i]) - 1);
			}
			sum--;
			res = Math.min(count, res);
		}
		return res;
	}

	public int leastBricks2(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, res = wall.size();
		for (List<Integer> row : wall) {
			sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			res = Math.min(res, wall.size() - entry.getValue());
		}
		return res;
	}
}
