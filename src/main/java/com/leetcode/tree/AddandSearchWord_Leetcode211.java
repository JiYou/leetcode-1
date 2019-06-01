package com.leetcode.tree;

import common.TrieNode;

public class AddandSearchWord_Leetcode211 {
	private TrieNode root;

	public AddandSearchWord_Leetcode211(){
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int j = word.charAt(i) - 'a';
			if(node.children[j] == null)
				node.children[j] = new TrieNode();
			node = node.children[j];
		}
		node.isWord = true;
		node.word = word;
	}

	public boolean search(String word){
		return find(word, root, 0);
	}

	private boolean find(String word, TrieNode node, int index) {
		if (index == word.length()) return node.isWord;
		if (word.charAt(index) == '.') {
			for (TrieNode tmp : node.children) {
				if (tmp != null && find(word, tmp, index + 1))
					return true;
			}
			return false;
		} else {
			int j = word.charAt(index) - 'a';
			TrieNode tmp = node.children[j];
			return tmp != null && find(word, tmp, index + 1);
		}
	}
}
