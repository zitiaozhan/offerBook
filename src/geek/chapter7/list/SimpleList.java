/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.list;

/**
 * 实现单链表、循环链表、双向链表，支持增删操作
 *
 * @author xingye
 * @created 2020/11/17
 */
public class SimpleList {

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "SingleNode{" + "val=" + val + ", next=" + next + '}';
        }
    }

    private static class SingleList {
        private Node head;
        private Node tail;

        private void add(int val) {
            Node cur = new Node(val);
            if (null == head) {
                head = cur;
                tail = head;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }

        private boolean remove(int val) {
            Node pre = null;
            Node cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    if (head == cur) {
                        head = cur.next;
                    }
                    if (tail == cur) {
                        tail = pre;
                    }

                    if (null != pre) {
                        pre.next = cur.next;
                    }
                    cur.next = null;
                    return true;
                }
                pre = cur;
                cur = cur.next;
            }
            return false;
        }
    }

    private static class LoopList {
        private Node head;
        private Node tail;

        private void add(int val) {
            Node cur = new Node(val);
            if (null == head) {
                head = cur;
                tail = head;
            } else {
                tail.next = cur;
                tail = cur;
            }
            tail.next = head;
        }

        private boolean remove(int val) {
            if (null == head) {
                return false;
            }

            Node pre = tail;
            Node cur = head;
            Node next = cur.next;
            while (next != head) {
                if (cur.val == val) {
                    pre.next = next;
                    cur.next = null;
                    return true;
                }
                pre = cur;
                cur = next;
                next = next.next;
            }

            if (head == tail && head.val == val) {
                head = null;
                tail = null;
                return true;
            }
            return false;
        }
    }

    public static void main(String... args) {
        SingleList singleList = new SingleList();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.remove(3);
        System.out.println(singleList.head);
    }

}