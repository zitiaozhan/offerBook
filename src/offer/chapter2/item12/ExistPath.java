/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item12;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * <p>
 * P89:回溯法
 *
 * @author xingye
 * @created 2020/7/15
 */
public class ExistPath {

    public static void main(String... args) {
        ExistPath existPath = new ExistPath();
//        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        char[][] board = new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(existPath.exist(board, "abfb"));
    }

    public boolean exist(char[][] board, String word) {
        if (null == board || 0 == board.length || null == word || 0 == word.length()) {
            return false;
        }

        // 记录访问过的坐标
        boolean[][] visited = new boolean[board.length][board[0].length];

        // 遍历矩阵，遍历位置，外层循环：O(m * n)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && hasPath(board, i, j, word, visited, 0)) {
                    // 首字母对应，则可以进行寻找
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 寻找路径, 单次hasPath最坏为O(4^m或4^n)
     *
     * @param board   路径矩阵
     * @param line    当前行
     * @param column  当前列
     * @param word    单词
     * @param visited 访问标志矩阵
     * @param pos     要寻找的单词位置
     * @return 是否有路径存在
     */
    private boolean hasPath(char[][] board, int line, int column, String word, boolean[][] visited, int pos) {
        if (pos == word.length()) {
            return true;
        }

        boolean hasPath = false;
        // 行列位置有效 且 字符对应 且 未访问过
        if (line >= 0 && line < board.length && column >= 0 && column < board[0].length && board[line][column] == word.charAt(pos) && !visited[line][column]) {
            visited[line][column] = true;
            // 上下左右
            hasPath = hasPath(board, line - 1, column, word, visited, pos + 1) ||
                    hasPath(board, line + 1, column, word, visited, pos + 1) ||
                    hasPath(board, line, column - 1, word, visited, pos + 1) ||
                    hasPath(board, line, column + 1, word, visited, pos + 1);
            if (!hasPath){
                // 退回上一步状态
                visited[line][column] = false;
            }
        }
        return hasPath;
    }
}