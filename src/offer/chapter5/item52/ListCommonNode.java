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
 * @created 2020/8/30
 */
public class ListCommonNode {

    public static void main(String... args) {
        ListCommonNode commonNode = new ListCommonNode();
        ListNode node1 = new ListNode(1);
        System.out.println(commonNode.commonNode(node1, node1));
        ListNode node2 = new ListNode(2);
        System.out.println(commonNode.commonNode(node1, node2));
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        System.out.println(commonNode.commonNode(node1, node2));
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node3.next = node6;
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        node7.next = new ListNode(8);
        System.out.println(commonNode.commonNode(node1, node4));
    }

    private ListNode commonNode(ListNode root1, ListNode root2) {
        if (null == root1 || null == root2) {
            return null;
        }

        int len1 = 0, len2 = 0;
        ListNode index1 = root1;
        ListNode index2 = root2;
        // 1.分别统计两个链表的长度
        while (index1 != null) {
            len1++;
            index1 = index1.next;
        }
        while (index2 != null) {
            len2++;
            index2 = index2.next;
        }
        // 2.长链表先走 diff 次
        index1 = root1;
        index2 = root2;
        int diff = Math.max(len1, len2) - Math.min(len1, len2);
        if (len1 > len2) {
            while (diff > 0) {
                index1 = index1.next;
                diff--;
            }
        } else if (len2 > len1) {
            while (diff > 0) {
                index2 = index2.next;
                diff--;
            }
        }
        // 查找共同节点
        while (index1 != null && index2 != null) {
            if (index1 == index2) {
                return index1;
            }
            index1 = index1.next;
            index2 = index2.next;
        }

        return null;
    }

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" + "value=" + value + ", next=" + next + '}';
        }
    }
}