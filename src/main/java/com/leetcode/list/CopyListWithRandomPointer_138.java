package com.leetcode.list;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
	public RandomListNode2 copy(RandomListNode2 head) {
		if (head == null)
			return head;
		HashMap<RandomListNode2, RandomListNode2> map = new HashMap<>();
		RandomListNode2 node = head;

		while (node != null) {
			map.put(node, new RandomListNode2(node.label));
			node = node.next;
		}

		RandomListNode2 cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}

		return map.get(head);
	}

	public RandomListNode2 copy2(RandomListNode2 head) {
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
