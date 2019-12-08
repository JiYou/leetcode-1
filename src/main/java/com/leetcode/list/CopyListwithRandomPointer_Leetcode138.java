package com.leetcode.list;

import java.util.HashMap;

/**
 * Created by lhcxx on 18/9/27.
 */


class RandomListNode2 {
	int label;
	RandomListNode2 next, random;
	RandomListNode2(int label) {this.label = label;}
}

public class CopyListwithRandomPointer_Leetcode138 {
	public RandomListNode2 copyRandomList(RandomListNode2 head) {
		HashMap<RandomListNode2, RandomListNode2> map = new HashMap<>();
		RandomListNode2 cur = head;
		while (cur != null) {
			map.put(cur, new RandomListNode2(cur.label));
			cur = cur.next;
		}

		cur = head;

		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}
}
