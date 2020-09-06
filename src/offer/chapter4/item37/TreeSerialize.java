/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item37;

/**
 * P194
 * 序列化二叉树
 *
 * @author xingye
 * @created 2020/8/20
 */
public class TreeSerialize {

    public static void main(String... args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode4.left = treeNode2;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode4.right = treeNode5;

        TreeSerialize treeSerialize = new TreeSerialize();

        String serialize1 = treeSerialize.serialize(treeNode4);
        System.out.println(serialize1);

        TreeNode treeNode = treeSerialize.deserialization(serialize1);
        String serialize2 = treeSerialize.serialize(treeNode);
        System.out.println(serialize2);
    }

    private String serialize(TreeNode root) {
        if (null == root) {
            return null;
        }

        // 前序遍历实现序列化
        StringBuilder builder = new StringBuilder();
        serializeCore(root, builder);
        String string = builder.toString();
        return string.substring(0, string.length() - 1);
    }

    private TreeNode deserialization(String serializeTree) {
        if (null == serializeTree || serializeTree.length() == 0) {
            return null;
        }

        String[] treeNodesArray = serializeTree.split("#");
        return deserializationCore(treeNodesArray);
    }

    private void serializeCore(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append("*").append("#");
            return;
        }

        builder.append(root.val).append("#");
        serializeCore(root.left, builder);
        serializeCore(root.right, builder);
    }

    private int index = 0;

    private TreeNode deserializationCore(String[] treeNodesArray) {
        if (index >= treeNodesArray.length) {
            return null;
        }

        String ele = treeNodesArray[index];
        if ("*".equals(ele)) {
            return null;
        }

        try {
            TreeNode root = new TreeNode(Integer.parseInt(ele));
            index++;
            root.left = deserializationCore(treeNodesArray);
            index++;
            root.right = deserializationCore(treeNodesArray);
            return root;
        } catch (Exception e) {
            throw new IllegalArgumentException("不合法的字符");
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }
}