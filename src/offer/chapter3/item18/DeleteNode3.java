/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item18;

/**
 * P119
 * 删除链表的节点
 *
 * @author xingye
 * @created 2020/9/13
 */
public class DeleteNode3 {

    private ListNode deleteNode(ListNode root, ListNode target) {
        if (null == root) {
            return null;
        }

        // 头节点位置
        if (root == target) {
            ListNode next = root.next;
            root.next = null;
            return next;
        }
        // 尾节点位置
        if (target.next == null) {
            ListNode cur = root;
            while (cur.next != target && null != cur.next) {
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IllegalArgumentException("目标节点在链表中未找到");
            }
            cur.next = null;
            return root;
        }
        // 其他位置
        ListNode next = target.next;
        target.val = next.val;
        target.next = next.next;
        return root;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}