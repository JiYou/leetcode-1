package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _380_InsertDeleteGetRandom {
	HashMap<Integer, Integer> map;
	List<Integer> list;
	Random rdm;

	public _380_InsertDeleteGetRandom() {
		map = new HashMap<>();
		list = new ArrayList<>();
		rdm = new Random();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) return false;
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		int index = map.remove(val);
		int last = list.remove(list.size() - 1);
		if (index != list.size()) {
			map.put(last, index);
			list.set(index, last);
		}
		return true;
	}

	public int getRandom() {
		return list.get(rdm.nextInt(list.size()));
	}

}
