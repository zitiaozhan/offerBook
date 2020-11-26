/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day4;

/**
 * 实现一个字符集，只包含 a～z 这 26 个英文字母的 Trie 树
 *
 * @author xingye
 * @created 2020/11/26
 */
public class TrieTree {
    private Node head;

    private static class Node {
        private char val;
        private Node[] children;
        private boolean end;

        public Node(char val) {
            this.val = val;
            children = new Node[26];
        }
    }

    public TrieTree() {
        this.head = new Node('/');
    }

    public void addWord(String word) {
        if (null == word || 0 == word.length()) {
            return;
        }
        char[] chars = word.toCharArray();
        char first = 'a';

        Node index = head;
        for (char aChar : chars) {
            Node[] children = index.children;
            if (null == children[aChar - first]) {
                index = new Node(aChar);
                children[aChar - first] = index;
            } else {
                index = children[aChar - first];
            }
        }
        index.end = true;
    }

    public boolean exist(String word) {
        if (null == word || 0 == word.length()) {
            return false;
        }
        char[] chars = word.toCharArray();
        char first = 'a';

        Node index = head;
        for (char aChar : chars) {
            Node[] children = index.children;
            if (null == children[aChar - first]) {
                return false;
            } else {
                index = children[aChar - first];
            }
        }
        return index.end;
    }

    public static void main(String... args) {
        TrieTree trieTree = new TrieTree();
        trieTree.addWord("fuck");
        trieTree.addWord("tomorrow");
        trieTree.addWord("querying");
        System.out.println(trieTree.exist("tomorrow"));
        System.out.println(trieTree.exist("tomorow"));
        System.out.println(trieTree.exist("querying"));
        System.out.println(trieTree.exist("queryi"));
        trieTree.addWord("zoo");
        System.out.println(trieTree.exist("zoo"));
        System.out.println(trieTree.exist("zor"));
    }
}