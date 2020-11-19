/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day2;

/**
 * 用数组实现一个顺序栈
 * 用链表实现一个链式栈
 *
 * @author xingye
 * @created 2020/11/19
 */
public class MyStack {
    private String[] webName = new String[10];
    private int index = -1;
    private int size = 0;

    private static class ArrayStack {
        private int[] nums;
        private int end;
        private int size;

        public ArrayStack(int size) {
            this.size = size;
            nums = new int[size + 1];
            end = 0;
        }

        public boolean push(int num) {
            if (end >= size) {
                return false;
            }
            nums[end++] = num;
            return true;
        }

        public int pop() {
            if (end == 0) {
                throw new RuntimeException();
            }
            return nums[--end];
        }

        public int peek() {
            if (end == 0) {
                throw new RuntimeException();
            }
            return nums[end - 1];
        }
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }
    }

    private static class ListStack {
        private Node head;
        private Node tail;

        public void push(int num) {
            Node cur = new Node(num);
            if (null == head) {
                // 栈为空
                head = cur;
                tail = cur;
                return;
            }
            tail.next = cur;
            tail = cur;
        }

        public int pop() {
            if (null == head) {
                throw new RuntimeException("栈已空");
            }

            int res = tail.val;
            if (head == tail) {
                // 最后一个数字
                head = null;
                tail = null;
            } else {
                Node pre = head;
                while (pre.next != tail) {
                    pre = pre.next;
                }
                pre.next = null;
                tail = pre;
            }
            return res;
        }

        public int peek() {
            if (null == head) {
                throw new RuntimeException("栈已空");
            }
            return tail.val;
        }
    }

    public String forward() {
        if (index == size - 1) {
            return null;
        }
        return webName[++index];
    }

    public String backOff() {
        if (index == 0) {
            return null;
        }
        return webName[--index];
    }

    public void visit(String name) {
        webName[++index] = name;
        size = index + 1;
    }

    public static void main(String... args) {
        /*ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        System.out.println(Arrays.toString(arrayStack.nums));
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());*/

        /*ListStack listStack = new ListStack();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);
        listStack.push(6);
        System.out.println(listStack.head);
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());*/

        MyStack myStack = new MyStack();
        myStack.visit("home");
        myStack.visit("zhihu");
        myStack.visit("主页");
        myStack.visit("收藏");
        System.out.println(myStack.backOff());
        myStack.visit("等你来答");
        System.out.println(myStack.backOff());
        System.out.println(myStack.forward());
    }

}