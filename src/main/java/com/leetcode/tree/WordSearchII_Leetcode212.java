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

		for (int i = 0; i < boards.length; i++)
			for (int j = 0; j < boards[0].length; j++)
				dfs(boards, i, j, root, res);
		return res;
	}

	public TrieNode buildTree(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode p = root;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				if (p.children[i] == null)
					p.children[i] = new TrieNode();
				p = p.children[i];
			}
			p.word = word;
		}
		return root;
	}

	private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		if (i < 0 || i > board.length || j < 0 || j > board[0].length) return;
		char c = board[i][j];
		if (c == '#' || p.children[c - 'a'] == null) return;
		p = p.children[c - 'a'];
		if (p.word != null) {
			res.add(p.word);
			p.word = null;
		}
		board[i][j] = '#';
		dfs(board, i, j + 1, p, res);
		dfs(board, i, j - 1, p, res);
		dfs(board, i + 1, j, p, res);
		dfs(board, i - 1, j, p, res);
		board[i][j] = c;
	}
}
