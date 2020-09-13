/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item12;

/**
 * P89
 * 矩阵中的路径
 *
 * @author xingye
 * @created 2020/9/13
 */
public class ExistPath2 {

    private boolean existPath(char[][] matrix, String target) {
        if (null == target || 0 == target.length()) {
            return true;
        }
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return false;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        char[] chars = target.toCharArray();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == chars[0] && existPathCore(matrix, visited, chars, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existPathCore(char[][] matrix, boolean[][] visited, char[] chars, int index, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !visited[i][j] && index < chars.length && chars[index] == matrix[i][j]) {
            visited[i][j] = true;
            if (index == chars.length - 1) {
                return true;
            } else {
                boolean hasPath = existPathCore(matrix, visited, chars, index + 1, i - 1, j) || existPathCore(matrix, visited, chars, index + 1, i + 1, j) || existPathCore(matrix, visited, chars, index + 1, i, j - 1) || existPathCore(matrix, visited, chars, index + 1, i, j + 1);
                if (!hasPath) {
                    visited[i][j] = false;
                }
                return hasPath;
            }
        }
        return false;
    }

    public static void main(String... args) {
        ExistPath2 existPath2 = new ExistPath2();
        System.out.println(existPath2.existPath(new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}}, "bfce"));
    }

}