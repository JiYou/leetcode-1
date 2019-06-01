package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_Leetcode212 {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

	public List<String> findWords(char[][] boards, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTree(words);

	}

	public TrieNode buildTree(String[] words) {
		TrieNode root = new TrieNode();
		for (String s : words) {
			TrieNode node = root;
			for (char c : s.toCharArray()) {
				int j = c - 'a';
				if (node.children[j] == null)
					node.children[j] = new TrieNode();
				node = node.children[j];
			}
			node.word = s;
		}
		return root;
	}

	private void dfs()
}
