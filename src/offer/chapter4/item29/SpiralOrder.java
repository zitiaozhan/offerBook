/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item29;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author xingye
 * @created 2020/7/30
 */
public class SpiralOrder {
    public static void main(String... args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return new int[]{};
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int pos = 0, index = 0;
        while (matrix.length > pos * 2 && matrix[0].length > pos * 2) {
            index = printCur(matrix, pos, res, index);
            pos++;
        }
        return res;
    }

    private int printCur(int[][] matrix, int pos, int[] res, int index) {
        int endX = matrix[0].length - pos - 1;
        int endY = matrix.length - pos - 1;
        // 1.从左到右，总是发生
        for (int i = pos; i <= endX; i++) {
            res[index++] = matrix[pos][i];
        }
        // 2.从上到下，行数大于1时发生
        if (pos < endY) {
            for (int i = pos + 1; i <= endY; i++) {
                res[index++] = matrix[i][endX];
            }
        }
        // 3.从右到左，行数大于1且列数大于1时执行
        if (pos < endY && pos < endX) {
            for (int i = endX - 1; i >= pos; i--) {
                res[index++] = matrix[endY][i];
            }
        }
        // 4.从下到上，行数大于2且列数大于1时执行
        if (pos < endY - 1 && pos < endX) {
            for (int i = endY - 1; i > pos; i--) {
                res[index++] = matrix[i][pos];
            }
        }
        return index;
    }
}