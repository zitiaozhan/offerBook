/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item13;

/**
 * 机器人的运动范围
 * P92
 *
 * @author xingye
 * @created 2020/7/20
 */
public class MovingCount {

    public static void main(String... args) {
        MovingCount movingCount = new MovingCount();
//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] matrix = new int[][]{{1, 2, 3, 4}};
        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}};
//        int[][] matrix = new int[][]{};
        System.out.println(movingCount.movingCount(matrix, 4));
    }

    private int movingCount(int[][] matrix, int k) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // 从位置0,0开始
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return movingCount(matrix, 0, 0, visited, k);
    }

    /**
     * 某一位置可以进入的格子
     *
     * @param matrix  矩阵序列
     * @param line    行
     * @param column  列
     * @param visited 是否访问过
     * @param k       K值，数位之和不超过K
     * @return 可以进入的格子数量
     */
    private int movingCount(int[][] matrix, int line, int column, boolean[][] visited, int k) {
        if (line < 0 || column < 0 || line == matrix.length || column == matrix[0].length) {
            return 0;
        }

        int num = 0;
        // 没有访问过 且 可以进入
        if (!visited[line][column] && judgeEnter(line, column, k)) {
            // 上下左右
            visited[line][column] = true;
            num += 1;
            num += movingCount(matrix, line - 1, column, visited, k);
            num += movingCount(matrix, line + 1, column, visited, k);
            num += movingCount(matrix, line, column - 1, visited, k);
            num += movingCount(matrix, line, column + 1, visited, k);
        }
        return num;
    }

    /**
     * 判断数位之和是否小于等于k
     *
     * @param line   行坐标
     * @param column 列坐标
     * @param k      数位之和最大值
     * @return 能否进入该坐标点
     */
    private boolean judgeEnter(int line, int column, int k) {
        String lineStr = String.valueOf(line);
        String[] lineNumStrs = lineStr.split("");
        String columnStr = String.valueOf(column);
        String[] columnNumStrs = columnStr.split("");

        int sum = 0;
        for (String lineNumStr : lineNumStrs) {
            sum += Integer.parseInt(lineNumStr);
        }
        for (String columnNumStr : columnNumStrs) {
            sum += Integer.parseInt(columnNumStr);
        }
        return sum <= k;
    }
}