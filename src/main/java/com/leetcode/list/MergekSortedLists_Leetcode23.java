package com.leetcode.list;

import common.ListNode;

import java.util.PriorityQueue;

/**
 * Created by lhcxx on 18/10/23.
 */
public class MergekSortedLists_Leetcode23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return sort(lists, 0, lists.length - 1);
	}

	private ListNode sort(ListNode[] lists, int low, int high) {
		if (low >= high)
			return lists[low];
		int mid = (high - low) / 2 + low;
		ListNode l1 = sort(lists, low, mid);
		ListNode l2 = sort(lists, mid + 1, high);
		return merge(l1, l2);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}
		l2.next = merge(l1, l2.next);
		return l2;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		ListNode dummy = new ListNode();
		ListNode cur = dummy;

		for (ListNode node : lists)
			if (node != null)
				queue.offer(node);

		while (!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if (cur.next != null)
				queue.offer(cur.next);
		}
		return dummy.next;
	}

	public ListNode mergeKLists2_test(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return sort_test(lists, 0, lists.length - 1);
	}

	private ListNode sort_test(ListNode[] lists, int lo, int hi) {
		if (lo >= hi)
			return lists[lo];
		int mid = (hi - lo) / 2 + lo;
		ListNode l1 = sort_test(lists, lo, mid);
		ListNode l2 = sort_test(lists, mid + 1, hi);
		return merge_test(l1, l2);
	}

	private ListNode merge_test(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge_test(l1.next, l2);
			return l1;
		} else {
			l2.next = merge_test(l1, l2.next);
			return l2;
		}
	}



}
