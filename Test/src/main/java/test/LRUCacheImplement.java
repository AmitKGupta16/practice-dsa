package test;

import java.util.HashMap;

public class LRUCacheImplement {
    private DoublyNode head = new DoublyNode(-1, -1);
    private DoublyNode tail = new DoublyNode(-1, -1);
    private HashMap<Integer, DoublyNode> cache;
    int capacity;

    public LRUCacheImplement(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DoublyNode node = cache.get(key);
        remove(node);
        addToTail(node);
        return node.val;
    }

    public void set(int key, int val) {
        if (cache.containsKey(key)) {
            DoublyNode node = cache.get(key);
            node.val = val;
            remove(node);
            addToTail(node);
        } else {
            if (capacity == cache.size()) {
                DoublyNode node = head.next;
                remove(node);
                cache.remove(node.key);
            }
            DoublyNode node = new DoublyNode(key, val);
            addToTail(node);
            cache.put(key, node);
        }
    }

    public void remove(DoublyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToTail(DoublyNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

}

class DoublyNode {
    int key;
    int val;
    DoublyNode next, prev;

    public DoublyNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
