package leetcode;

import java.util.TreeMap;

public class _729_MyCalendar1 {
	private TreeMap<Integer, Integer> map;


	public _729_MyCalendar1() {
		map = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer nextStart = map.ceilingKey(start);
		if (nextStart != null && nextStart < end)
			return false;
		Integer prevStart = map.lowerKey(start);
		if (prevStart != null && map.get(prevStart) > start)
			return false;
		map.put(start, end);
		return true;
	}
}
