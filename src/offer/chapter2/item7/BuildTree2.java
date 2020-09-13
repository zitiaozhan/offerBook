/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * P62
 * 重建二叉树
 * 提供前序&中序序列
 *
 * @author xingye
 * @created 2020/9/12
 */
public class BuildTree2 {

    private Node buildTree(int[] preOrder, int[] midOrder) {
        if (null == preOrder || null == midOrder) {
            return null;
        }
        if (preOrder.length != midOrder.length) {
            throw new IllegalArgumentException("提供待重建序列有误");
        }

        // 递归过程
        return buildTreeCore(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
    }

    private Node buildTreeCore(int[] preOrder, int preStart, int preEnd, int[] midOrder, int midStart, int midEnd) {
        if (preStart <= preEnd && midStart <= midEnd) {
            // 前序序列：根节点
            int rootVal = preOrder[preStart];
            Node root = new Node(rootVal);
            // 中序序列：左右节点
            int rootIndex = -1;
            for (int i = midStart; i <= midEnd; i++) {
                if (midOrder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }
            if (rootIndex == -1) {
                throw new IllegalArgumentException("提供待重建序列有误");
            }
            // 左右节点数量
            int leftSize = rootIndex - midStart;
            root.left = buildTreeCore(preOrder, preStart + 1, preStart + leftSize, midOrder, midStart, rootIndex - 1);
            root.right = buildTreeCore(preOrder, preStart + leftSize + 1, preEnd, midOrder, rootIndex + 1, midEnd);
            return root;
        }
        return null;
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }

    private void printTreeByLevel(Node root) {
        if (null == root) {
            return;
        }
        Node nextLevel = root, printPoint = root;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        List<Integer> curLineValues = new LinkedList<>();
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.poll();
            curLineValues.add(root.val);

            if (null != root.left) {
                nodeQueue.add(root.left);
                nextLevel = root.left;
            }
            if (null != root.right) {
                nodeQueue.add(root.right);
                nextLevel = root.right;
            }

            if (printPoint == root) {
                printPoint = nextLevel;
                System.out.println(curLineValues);
                curLineValues = new LinkedList<>();
            }
        }
    }

    public static void main(String... args) {
        BuildTree2 buildTree2 = new BuildTree2();
        buildTree2.printTreeByLevel(buildTree2.buildTree(new int[]{3, 2, 1}, new int[]{2, 3, 1}));
        //System.out.println(buildTree2.buildTree(new int[]{3, 2, 1}, new int[]{2, 1, 1}));
        buildTree2.printTreeByLevel(buildTree2.buildTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}));
        buildTree2.printTreeByLevel(buildTree2.buildTree(new int[]{0, 4, 8, 3, 2, 1}, new int[]{4, 3, 8, 0, 1, 2}));
    }

}