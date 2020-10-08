/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU过期缓存
 *
 * @author xingye
 * @created 2020/10/8
 */
public class ExpiresCache {
    /** 大小 */
    private int size;
    /** 头结点 */
    private ListNode head;
    /** 尾节点 */
    private ListNode tail;
    /** 哈希表 */
    private Map<String, ListNode> ht = new HashMap<>();

    public static ExpiresCache create(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("大小不能小于1");
        }
        ExpiresCache cache = new ExpiresCache();
        cache.size = size;
        return cache;
    }

    /**
     * 设置KV
     */
    public void set(String key, String value) {
        ListNode listNode = ht.get(key);
        if (null != listNode) {
            listNode.value = value;
            return;
        }

        ListNode curNode = new ListNode(key, value);

        int curSize = ht.size();
        if (curSize >= size) {
            // 淘汰最后一个节点
            removeTail();
        }
        // 直接放到队头
        pushHead(curNode);
        // 加到哈希表
        ht.put(key, curNode);
    }

    /**
     * 获取值
     */
    public String get(String key) {
        ListNode listNode = ht.get(key);
        return null == listNode ? null : listNode.value;
    }

    /**
     * 删除key
     */
    public String remove(String key) {
        ListNode listNode = ht.get(key);
        if (null == listNode) {
            return null;
        }

        ListNode preNode = listNode.pre;
        ListNode nextNode = listNode.next;
        if (null != preNode) {
            preNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (null != nextNode) {
            nextNode.pre = preNode;
        } else {
            tail = preNode;
        }
        listNode.pre = null;
        listNode.next = null;
        return ht.remove(key).value;
    }

    private void pushHead(ListNode curNode) {
        // 放到队头
        curNode.next = head;
        if (null != head) {
            head.pre = curNode;
        }
        head = curNode;
        if (null == tail) {
            tail = head;
        }
    }

    private void removeTail() {
        if (null == tail) {
            return;
        }
        ht.remove(tail.key);
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        // 最后一个节点的上个节点
        ListNode preNode = tail.pre;
        tail.pre = null;
        preNode.next = null;
        tail = preNode;
    }

    private void print() {
        ListNode node = head;
        System.out.print("缓存大小：" + getSize() + "  ");
        while (node != null) {
            System.out.println("print: key=" + node.key + ", value=" + node.value);
            node = node.next;
        }
    }

    // 双向链表
    private static class ListNode {
        private ListNode pre;
        private ListNode next;
        private String key;
        private String value;

        public ListNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getSize() {
        return ht.size();
    }

    public ListNode getHead() {
        return head;
    }

    public static void main(String... args) {
        ExpiresCache expiresCache = ExpiresCache.create(3);
        expiresCache.set("k1", "v1");
        expiresCache.set("k2", "v2");
        expiresCache.set("k3", "v3");
        System.out.println("remove: " + expiresCache.remove("k1"));
        System.out.println("remove: " + expiresCache.remove("k3"));
        System.out.println("remove: " + expiresCache.remove("k2"));
        expiresCache.print();
    }
}