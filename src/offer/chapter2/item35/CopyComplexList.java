/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item35;

/**
 * P187
 * 复杂链表的复制
 *
 * @author xingye
 * @created 2020/8/19
 */
public class CopyComplexList {

    public static void main(String... args) {
        CopyComplexList copyComplexList = new CopyComplexList();

        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        node1.next = node2;
        node1.sibling = node2;
        node2.sibling = node1;

        ComplexListNode node = copyComplexList.copyComplexList(node1);

        ComplexListNode cur = node;
        while (cur != null) {
            ComplexListNode next = cur.next;
            System.out.println(cur);
            System.out.println("sibling: " + cur.sibling);

            cur = next;
        }
    }

    public ComplexListNode copyComplexList(ComplexListNode node) {
        if (null == node) {
            return null;
        }

        // 1.节点拷贝
        ComplexListNode cur = node;
        while (cur != null) {
            ComplexListNode next = cur.next;
            ComplexListNode copyCur = new ComplexListNode(cur.value);

            cur.next = copyCur;
            copyCur.next = next;

            cur = next;
        }

        // 2.拷贝 sibling
        ComplexListNode index = node;
        ComplexListNode copyIndex;
        while (index != null) {
            copyIndex = index.next;
            if (null != index.sibling) {
                copyIndex.sibling = index.sibling.next;
            }

            index = copyIndex.next;
        }

        // 3.解链
        ComplexListNode head = node.next;
        index = node;
        while (index != null) {
            copyIndex = index.next;
            index.next = copyIndex.next;
            index = index.next;
            if (null != index) {
                copyIndex.next = index.next;
            }
        }

        return head;
    }

    private static class ComplexListNode {
        private int value;
        private ComplexListNode next;
        private ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ComplexListNode{" + "value=" + value + ", next=" + next + '}';
        }
    }
}