/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @author xingye
 * @created 2020/9/17
 */
public class TreeToDoublyList {

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        // 非递归中序遍历
        Stack<Node> nodeStack = new Stack<>();
        Node cur = root;
        List<Node> midOrder = new ArrayList<>();
        while (cur != null || !nodeStack.isEmpty()) {
            if (cur != null) {
                nodeStack.push(cur);
                cur = cur.left;
            } else {
                cur = nodeStack.pop();
                midOrder.add(cur);
                cur = cur.right;
            }
        }

        for (int i = 0; i < midOrder.size() - 1; i++) {
            midOrder.get(i).right = midOrder.get(i + 1);
            midOrder.get(i + 1).left = midOrder.get(i);
        }
        midOrder.get(0).left = midOrder.get(midOrder.size() - 1);
        midOrder.get(midOrder.size() - 1).right = midOrder.get(0);
        return midOrder.get(0);
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;
    }
}