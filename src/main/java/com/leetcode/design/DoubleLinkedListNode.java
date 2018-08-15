package com.leetcode.design;

public class DoubleLinkedListNode {
    private int val;
    private int key;
    private DoubleLinkedListNode pre;
    private DoubleLinkedListNode next;

    public DoubleLinkedListNode(int val, int key) {
        this.val = val;
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public int getKey() {
        return key;
    }

    public DoubleLinkedListNode getPre() {
        return pre;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setPre(DoubleLinkedListNode pre) {
        this.pre = pre;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }
}
