package com.adv.linkedlist.linkedlist3.assignment;


import java.util.HashMap;

public class LRUCache {
    private DoublyListNode head = new DoublyListNode(-1,-1);
    private DoublyListNode tail = new DoublyListNode(-1,-1);
    private HashMap<Integer,DoublyListNode> cache = null;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))  return -1;
        DoublyListNode node = cache.get(key);
        remove(node);
        addToTail(node);
        return node.val;
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            DoublyListNode node = cache.get(key);
            node.val = value;
            remove(node);
            addToTail(node);

        } else {
            if(cache.size() == capacity){
                DoublyListNode node = head.next;
                remove(node);
                cache.remove(node.key);
            }
            DoublyListNode node = new DoublyListNode(key,value);
            addToTail(node);
            cache.put(key,node);
        }
    }



    public void addToTail(DoublyListNode node) {
        node.next = tail;
        node.prev=  tail.prev;
        tail.prev = node;
        node.prev.next = node;
      //  tail.prev.next = node;
       // tail.prev = node;
    }

    public void remove(DoublyListNode node) {
//        DoublyListNode prev = node.prev;
//        DoublyListNode next = node.next;
//        prev.next = next;
//        next.prev = prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }



}
class DoublyListNode {
    int val;
    int key;
    DoublyListNode next,prev;

    public DoublyListNode(int key, int val) {
        this.val= val;
        this.key = key;
        this.next = this.prev = null;
    }
}
