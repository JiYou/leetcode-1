package com.leetcode.common;

public class FindUnion {
	private int[] roots;

	public FindUnion(int n) {
		roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = i;
	}

	private int find(int i) {
		int root = i;
		while (root != roots[root]) {
			root = roots[root];
		}
		while (i != roots[i]) {
			int tmp = roots[i];
			roots[i] = root;
			i = tmp;
		}
		return root;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		roots[proot] = qroot;
	}

}
