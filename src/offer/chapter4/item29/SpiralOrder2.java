/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item29;

import java.util.Arrays;

/**
 * P161
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author xingye
 * @created 2020/9/15
 */
public class SpiralOrder2 {

    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return new int[]{};
        }

        int index = 0;
        int line = matrix.length, row = matrix[0].length;
        int[] nums = new int[line * row];
        // 上下左右
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                nums[index++] = matrix[up][i];
            }
            if (++up > down) {
                break;
            }

            // 从上到下
            for (int i = up; i <= down; i++) {
                nums[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }

            // 从右到左
            for (int i = right; i >= left; i--) {
                nums[index++] = matrix[down][i];
            }
            if (--down < up) {
                break;
            }

            // 从下到上
            for (int i = down; i >= up; i--) {
                nums[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return nums;
    }

    public static void main(String... args) {
        SpiralOrder2 spiralOrder2 = new SpiralOrder2();
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1, 2, 3}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1, 2}, {3, 4}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1}, {2}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        System.out.println(Arrays.toString(spiralOrder2.spiralOrder(new int[][]{{7}, {9}, {6}})));
    }
}