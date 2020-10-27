/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item39;

/**
 * 8皇后问题：
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 * 你可以看我画的图，第一幅图是满足条件的一种方法，第二幅图是不满足条件的。
 * 八皇后问题就是期望找到所有满足这种要求的放棋子方式。
 * https://time.geekbang.org/column/article/74287
 *
 * @author xingye
 * @created 2020/10/27
 */
public class EightQueens {
    private int[] rows = new int[8];

    private void eightQueens(int row) {
        if (row == 8) {
            // 摆放完毕
            printQueens(rows);
            return;
        }

        // column表示row行的棋子放在第几列
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                rows[row] = column;
                // 回溯关键
                eightQueens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (rows[i] == column) {
                // 在同一列
                return false;
            }
            if (leftUp >= 0 && rows[i] == leftUp) {
                // 与上一行构成对角线
                return false;
            }
            if (rightUp < 8 && rows[i] == rightUp) {
                // 与上一行构成对角线
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String... args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.eightQueens(0);
    }
}