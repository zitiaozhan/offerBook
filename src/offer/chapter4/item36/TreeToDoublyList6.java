/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @author xingye
 * @created 2020/12/4
 */
public class TreeToDoublyList6 {
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + '}';
        }
    }

    private Node pre = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        // 中序遍历，使用递归
        midOrder(root);
        pre.right = head;
        head.left = pre;

        return head;
    }

    private void midOrder(Node cur) {
        if (null == cur) {
            return;
        }

        midOrder(cur.left);
        if (null == head) {
            head = cur;
        }
        cur.left = pre;
        if (null != pre) {
            pre.right = cur;
        }
        pre = cur;
        midOrder(cur.right);
    }

    public static void main(String... args) {
        TreeToDoublyList6 toDoublyList = new TreeToDoublyList6();

        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(8);
        Node node7 = new Node(12);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        Node head = toDoublyList.treeToDoublyList(node1);
        for (int i = 0; i < 7; i++) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}