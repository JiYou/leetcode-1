package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _582_KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++) {
			if (ppid.get(i) > 0) {
				List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
				list.add(pid.get(i));
				map.put(ppid.get(i), list);
			}
		}

		List<Integer> res = new ArrayList<>();
		res.add(kill);
		killAllProcess(res, kill, map);
		return res;
	}

	private void killAllProcess(List<Integer> res, int kill, HashMap<Integer, List<Integer>> map) {
		if (map.containsKey(kill)) {
			for (int id : map.get(kill)) {
				res.add(id);
				killAllProcess(res, id, map);
			}
		}
	}
}
