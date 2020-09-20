/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item52;

/**
 * P253
 * 两个链表的第一个公共节点
 *
 * @author xingye
 * @created 2020/9/20
 */
public class ListCommonNode2 {

    private Node listCommonNode(Node node1, Node node2) {
        if (null == node1 || null == node2) {
            return null;
        }

        // 分别得到长度
        int len1 = 0;
        int len2 = 0;
        Node cur = node1;
        while (cur != null) {
            cur = cur.next;
            len1++;
        }
        cur = node2;
        while (cur != null) {
            cur = cur.next;
            len2++;
        }

        // 长的先走 diff
        if (len1 >= len2) {
            while (len1 > len2) {
                node1 = node1.next;
                len1++;
            }
        } else {
            while (len1 < len2) {
                node2 = node2.next;
                len2++;
            }
        }

        // 一起走
        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}