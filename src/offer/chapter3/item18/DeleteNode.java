/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item18;

/**
 * 给定头结点与要删除的节点，删除链表节点，时间复杂度：O(1)
 * P119
 *
 * @author xingye
 * @created 2020/7/22
 */
public class DeleteNode {
    public static void main(String... args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode node = deleteNode.init(4);
        deleteNode.printNode(node);
        ListNode root = deleteNode.deleteNode(node, node.next.next);
        deleteNode.printNode(root);
    }

    private void printNode(ListNode root) {
        while (root != null) {
            System.out.print(root.value + ",");
            root = root.next;
        }
        System.out.println();
    }

    private ListNode init(int len) {
        if (len < 1) {
            return null;
        }
        ListNode root = new ListNode(((int) (Math.random() * 123) + 13), null);
        ListNode pre = root;
        ListNode cur;
        for (int i = 1; i < len; i++) {
            cur = new ListNode(((int) (Math.random() * 123) + 13), null);
            pre.next = cur;
            pre = cur;
        }
        return root;
    }

    /**
     * 删除链表中节点，不考虑节点不存在
     * 复制删除法：将要删除的节点的下一个节点的值复制到本节点，然后删除下一个节点
     */
    private ListNode deleteNode(ListNode head, ListNode willDel) {
        if (null == head || null == willDel) {
            return null;
        }

        ListNode nextNode = willDel.next;
        if (head == willDel && head.next == null) {
            // 链表只有一个节点
            head = null;
        } else if (null == nextNode) {
            // 如果为尾节点，则需要遍历删除
            ListNode pre = head;
            while (pre.next != willDel) {
                pre = pre.next;
            }
            pre.next = null;
        } else {
            willDel.value = nextNode.value;
            willDel.next = nextNode.next;
        }
        return head;
    }

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}