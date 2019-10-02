package com.leetcode.tree;

import com.leetcode.common.TrieNode;

public class ImplementTrie_Leetcode208 {
	TrieNode root;

	public ImplementTrie_Leetcode208() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int j = word.charAt(i) - 'a';
			if (node.children[j] == null) {
				node.children[j] = new TrieNode();
			}
			node = node.children[j];
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i ++) {
			int j = word.charAt(i) - 'a';
			if (node.children[j] == null)
				return false;
			node = node.children[j];
		}
		return node.isWord;
	}

	public boolean startWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i< prefix.length(); i++){
			int j = prefix.charAt(i) - 'a';
			if (node.children[j] == null)
				return false;
			node = node.children[j];
		}
		return true;
	}
}
