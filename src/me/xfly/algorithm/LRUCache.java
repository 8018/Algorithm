package me.xfly.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private DLinkedNode head,tail;
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }

        removeNode(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            if(size == capacity){
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }

            addToHead(node);
            cache.put(key,node);
            size++;

        }else{
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }


}
