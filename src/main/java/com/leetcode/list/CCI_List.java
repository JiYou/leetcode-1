package com.leetcode.list;



import common.ListNode;

import java.util.HashMap;
import java.util.Stack;

public class CCI_List {
    public static void deleteDuplicates(ListNode node) {
        if (node == null)
            return;
        HashMap map = new HashMap();
        ListNode previous = node;
        while (node != null) {
            if (map.containsKey(node.val))
                previous.next = node.next;
            else {
                map.put(node.val,true);
                previous = node;
            }
            node = node.next;
        }
    }

    public ListNode partition(ListNode node, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while(node != null) {
            if (node.val < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = node;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }

            }else {
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = node;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = node.next;
        }
        if (beforeStart == null)
            return afterStart;
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public ListNode addLists(ListNode node1, ListNode node2, int carry) {
        if ( node1 == null && node2 == null && carry == 0)
            return null;
        ListNode result = new ListNode();

        int value = carry;
        if (node1 != null)
            value += node1.val;
        if (node2 != null)
            value += node2.val;
        result.val = value % 10;
        ListNode more = addLists(node1 == null ? null : node1.next,
                node2 == null ? null : node2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }

    public ListNode findBeginNode(ListNode head) {
        if (head == null)
             return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static ListNode reverseHead(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        head = pre;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null & fast.next != null) {
            stack.push(fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }


}
