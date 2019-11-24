package leetcode;

import java.util.HashMap;

public class _666_PathSum {

	int res = 0, curVal = 0;
	public int pathSum(int[] nums) {
		if (nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int depth = num / 100;
			int pos = num % 100 / 10;
			int val = num % 10;
			int key = (int)Math.pow(2, depth - 1) + pos - 1;
			map.put(key, val);
		}
		help(map, 1);
		return res;
	}

	private void help(HashMap<Integer, Integer> map, int index) {
		if (!map.containsKey(index))
			return;
		curVal += map.get(index);

		if (!map.containsKey(2 * index) && !map.containsKey(2 * index + 1))
			res += curVal;
		if (map.containsKey(2 * index))
			help(map, 2 * index);
		if (map.containsKey(2 * index + 1))
			help(map, 2 * index + 1);
		curVal -= map.get(index);
	}

}
