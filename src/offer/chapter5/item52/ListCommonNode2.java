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

    private ListNode listCommonNode(ListNode listNode1, ListNode listNode2) {
        if (null == listNode1 || null == listNode2) {
            return null;
        }

        // 分别得到长度
        int len1 = 0;
        int len2 = 0;
        ListNode cur = listNode1;
        while (cur != null) {
            cur = cur.next;
            len1++;
        }
        cur = listNode2;
        while (cur != null) {
            cur = cur.next;
            len2++;
        }

        // 长的先走 diff
        if (len1 >= len2) {
            while (len1 > len2) {
                listNode1 = listNode1.next;
                len1--;
            }
        } else {
            while (len1 < len2) {
                listNode2 = listNode2.next;
                len2--;
            }
        }

        // 一起走
        while (listNode1 != null && listNode2 != null) {
            if (listNode1 == listNode2) {
                return listNode1;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return null;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}