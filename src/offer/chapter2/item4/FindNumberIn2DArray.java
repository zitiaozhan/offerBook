/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item4;

/**
 * 剑指offer第3题
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author xingye
 * @created 2020/7/10
 */
public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }

        int x = matrix[0].length - 1, y = 0;
        while (x >= 0 && y < matrix.length) {
            int cur = matrix[y][x];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                // 消除一列
                x--;
            } else {
                // 消除一行
                y++;
            }
        }
        return false;
    }

    public static void main(String... args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }
}