package com.leetcode.design;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int capacity;
    private int len;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.getVal();
        } else
            return -1;
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = node.getPre();
        DoubleLinkedListNode post = node.getNext();

        if (pre != null)
            pre.setNext(post);
        else
            head = post;
        if (post != null)
            post.setPre(pre);
        else
            end = pre;
    }

    public void setHead(DoubleLinkedListNode node) {
        node.setNext(head);
        node.setPre(null);
        if (head != null)
            head.setPre(node);
        head = node;
        if (end == null)
            end = node;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.setVal(value);
            removeNode(oldNode);
            setHead(oldNode);
        }else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len++;
            }else {
                map.remove(end.getKey());
                end = end.getPre();
                if (end != null)
                    end.setNext(null);
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }


}

