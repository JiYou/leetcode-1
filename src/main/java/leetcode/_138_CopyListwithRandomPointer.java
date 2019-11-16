package leetcode;


import java.util.HashMap;

class RandomListNode2 {
	int label;
	RandomListNode2 next, random;
	RandomListNode2(int label) {this.label = label;}
}

public class _138_CopyListwithRandomPointer {
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

	public RandomListNode2 copyRandomList2(RandomListNode2 head) {
		if (head == null)
			return head;
		RandomListNode2 cur = head, next;
		//copy cur
		while (cur != null) {
			next = cur.next;
			RandomListNode2 copy = new RandomListNode2(cur.label);
			cur.next = copy;
			copy.next = next;
			cur = cur.next;
		}
		cur = head;
		//copy random
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		cur = head;
		RandomListNode2 dummy = new RandomListNode2(0);
		dummy.next = cur.next;
		RandomListNode2 copy;

		while (cur != null) {
			copy = cur.next;
			cur.next = cur.next.next;
			cur = copy.next;
			copy.next = cur.next;
		}

		return dummy.next;
	}

}
