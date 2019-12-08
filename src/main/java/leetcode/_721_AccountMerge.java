package leetcode;

import java.util.*;

public class _721_AccountMerge {


	//unfinished
	public List<List<String>> accountMerge3(List<List<String>> accounts) {
		int[] roots = new int[accounts.size()];
		HashMap<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < accounts.size(); i++) {
			roots[i] = i;
			for (int j = 1; j < accounts.get(i).size(); j++) {
				if (map.get(accounts.get(i).get(j)) == null) {
					List<Integer> list = new ArrayList<>();
					map.put(accounts.get(i).get(j), list);
				}
				map.get(accounts.get(i).get(j)).add(i);
			}
		}

		for (Map.Entry<String, List<Integer>> enrty : map.entrySet()) {
			for (int i = 0; i < enrty.getValue().size(); i++) {
				int p = find(roots, i);
				int q = find(roots, enrty.getValue().get(0));
				if (p != q)
					roots[p] = q;
			}
		}

		List<List<String>> res = new ArrayList<>();

		return res;
	}

	private int find(int[] root, int x) {
		return root[x] == x ? x : find(root, root[x]);
	}

	HashMap<String, String> parent;

	public List<List<String>> accountMerge(List<List<String>> accounts) {
		parent = new HashMap<>();
		HashMap<String, Set<String>> unions = new HashMap<>();
		HashMap<String, String> owners = new HashMap<>();

		List<List<String>> res = new ArrayList<>();

		for (List<String> list : accounts) {
			for (int i = 1; i < list.size(); i++) {
				parent.put(list.get(i), list.get(i));
				owners.put(list.get(i), list.get(0));
			}
		}

		for (List<String> list : accounts) {
			String p = find2(list.get(1));
			for (int i = 2; i < list.size(); i++)
				parent.put(find2(list.get(i)), p);
		}

		for (List<String> list : accounts) {
			String p = find2(list.get(1));
			unions.putIfAbsent(p, new HashSet<>());
			for (int i = 1; i < list.size(); i++)
				unions.get(p).add(list.get(i));
		}

		for (String key : unions.keySet()) {
			String owner = owners.get(key);
			List<String> union = new ArrayList<>(unions.get(key));
			Collections.sort(union);
			union.add(0, owner);
			res.add(union);
		}
		return res;
	}

	private String find2(String s) {
		return s == parent.get(s) ? s : find2(parent.get(s));
	}


}
