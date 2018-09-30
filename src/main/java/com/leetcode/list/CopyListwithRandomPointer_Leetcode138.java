package com.leetcode.list;

import java.util.HashMap;

/**
 * Created by lhcxx on 18/9/27.
 */


class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int label) {this.label = label;}
}

public class CopyListwithRandomPointer_Leetcode138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cur = head;
		while (cur != null) {
			map.put(cur, new RandomListNode(cur.label));
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
