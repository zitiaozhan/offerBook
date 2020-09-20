/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item37;

import java.util.Stack;

/**
 * REDO: 重做标签
 *
 * @author xingye
 * @created 2020/9/18
 */
public class TreeSerialize2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "null";
        }

        StringBuilder builder = new StringBuilder();

        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            if (null == node) {
                builder.append("null").append("#");
            } else {
                builder.append(node.val).append("#");
                treeNodes.push(node.right);
                treeNodes.push(node.left);
            }
        }

        // 去掉最后面的符号
        String target = builder.toString();
        return target.substring(0, target.length() - 1);
    }

    private int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data) {
            return null;
        }

        String[] nodes = data.split("#");
        return deserializeCore(nodes);
    }

    private TreeNode deserializeCore(String[] nodes) {
        if (index >= nodes.length) {
            return null;
        }

        String node = nodes[index];
        if (node.equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        index++;
        treeNode.left = deserializeCore(nodes);
        index++;
        treeNode.right = deserializeCore(nodes);
        return treeNode;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String... args) {
        TreeSerialize2 serialize2 = new TreeSerialize2();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;

        String serialize = serialize2.serialize(node1);
        System.out.println("serialize = " + serialize);
        TreeNode deserialize = serialize2.deserialize(serialize);

        String serialize1 = serialize2.serialize(deserialize);
        System.out.println("serialize1 = " + serialize1);
    }

}