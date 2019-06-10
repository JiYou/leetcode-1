package com.leetcode.DP;

import java.util.HashMap;
import java.util.List;

public class WordBreakII_140 {

	HashMap<Integer, List<String>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, 0);
	}

	private List<String> dfs(String s, List<String> wordDict, int start) {

	}


}
