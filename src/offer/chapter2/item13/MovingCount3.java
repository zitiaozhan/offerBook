/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item13;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author xingye
 * @created 2020/9/13
 */
public class MovingCount3 {

    public int movingCount(int m, int n, int k) {
        if (m < 1 || n < 1) {
            return 0;
        }

        return movingCountCore(m, n, 0, 0, k, new boolean[m][n]);
    }

    private int movingCountCore(int m, int n, int line, int row, int k, boolean[][] visited) {
        if (line >= 0 && line < m && row >= 0 && row < n && !visited[line][row] && bitSum(line, row) <= k) {
            visited[line][row] = true;
            return 1 + movingCountCore(m, n, line - 1, row, k, visited) + movingCountCore(m, n, line + 1, row, k, visited) + movingCountCore(m, n, line, row - 1, k, visited) + movingCountCore(m, n, line, row + 1, k, visited);
        }
        return 0;
    }

    private int bitSum(int line, int row) {
        int bitSum = 0;
        while (line > 0) {
            bitSum += line % 10;
            line /= 10;
        }
        while (row > 0) {
            bitSum += row % 10;
            row /= 10;
        }
        return bitSum;
    }

    public static void main(String... args) {
        MovingCount3 movingCount3 = new MovingCount3();
        System.out.println(movingCount3.movingCount(1, 1, 0));
        System.out.println(movingCount3.movingCount(2, 3, 1));
        System.out.println(movingCount3.movingCount(3, 1, 0));
    }

}