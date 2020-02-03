package leetcode;

public class _211_AddandSearchWord {
	class TrieNode {

		TrieNode[] children;
		boolean isWord;
		String word;

		public TrieNode() {
			children = new TrieNode[26];
			isWord = false;
			word = "";
		}
	}


	TrieNode root;

	public _211_AddandSearchWord() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = new TrieNode();
		for (int i = 0; i < word.length(); i++) {
			int j = word.charAt(i) - 'a';
			if (node.children[j] == null) {
				node.children[j] = new TrieNode();
			}
			node = node.children[j];
		}
		node.isWord = true;
		node.word = word;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return find(word, root, 0);
	}

	public boolean find(String word, TrieNode node, int index) {
			if (index == word.length())
				return node.isWord;
			if (word.charAt(index) == '.') {
				for(TrieNode tmp : node.children) {
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
