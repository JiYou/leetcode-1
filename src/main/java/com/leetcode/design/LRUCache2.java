package com.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache2 {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.next = null;
            node.pre = tail;
            tail = node;

        }
        return node.val;

    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node != null) {
            node.val = val;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else{
            Node newNode = new Node(key, val);
            if (capacity == 0) {
                Node tmp = head;
                head = head.next;
                map.remove(tmp.key);
                capacity++;
            }
            if(head == null && tail == null) {
                head = newNode;
            }else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(newNode.key, newNode);
            capacity--;
        }
    }


}
