package com.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache2 {
    private int len;
    private int capacity;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private LinkedList cache = new LinkedList();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }
}
