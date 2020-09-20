/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * REDO: 重做标签
 *
 * @author xingye
 * @created 2020/9/18
 */
public class TreeToDoublyList2 {
    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        midOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void midOrder(Node cur) {
        if (null == cur) {
            return;
        }

        midOrder(cur.left);

        if (null == pre) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;

        midOrder(cur.right);
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;
    }

}