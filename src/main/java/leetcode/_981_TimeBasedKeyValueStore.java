package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _981_TimeBasedKeyValueStore {
	Map<String, TreeMap<Integer, String>> map;


	_981_TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}


	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> tmap = map.get(key);
		if (tmap == null) {
			tmap = new TreeMap<>();
			map.put(key,tmap);
		}
		tmap.put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> tmap = map.get(key);
		if (tmap == null)
			return "";
		Integer floorKey = tmap.floorKey(timestamp);
		if (floorKey == null)
			return "";
		return tmap.get(floorKey);
	}
}
