/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item37;

/**
 * 输的序列化反序列化
 *
 * @author xingye
 * @created 2020/9/26
 */
public class TreeSerialize3 {

    private String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrderSerialize(root, builder);

        String target = builder.toString();
        return target.substring(0, target.length() - 1);
    }

    private void preOrderSerialize(TreeNode node, StringBuilder builder) {
        if (null == node) {
            builder.append("*").append("#");
            return;
        }

        // 前序序列化
        builder.append(node.val).append("#");
        preOrderSerialize(node.left, builder);
        preOrderSerialize(node.right, builder);
    }

    private TreeNode deserialization(String target) {
        String[] nodeStrings = target.split("#");
        return preOrderDeserialization(nodeStrings);
    }

    private int index = 0;

    private TreeNode preOrderDeserialization(String[] nodeStrings) {
        if (index < nodeStrings.length) {
            String curNodeString = nodeStrings[index++];
            if (curNodeString.equals("*")) {
                return null;
            } else {
                TreeNode curNode = new TreeNode(Integer.parseInt(curNodeString));
                curNode.left = preOrderDeserialization(nodeStrings);
                curNode.right = preOrderDeserialization(nodeStrings);
                return curNode;
            }
        }
        return null;
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
        TreeSerialize3 serialize3 = new TreeSerialize3();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;

        String serialize = serialize3.serialize(node1);
        System.out.println("serialize = " + serialize);
        TreeNode deserialize = serialize3.deserialization(serialize);

        serialize = serialize3.serialize(deserialize);
        System.out.println("serialize = " + serialize);
    }

}