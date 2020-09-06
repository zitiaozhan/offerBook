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
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author xingye
 * @created 2020/9/6
 */
public class MovingCount2 {

    public int movingCount(int m, int n, int k) {
        if (k < 0) {
            return 0;
        }
        boolean[][] flag = new boolean[m][n];
        return movingCount(0, 0, m, n, k, flag);
    }

    private int movingCount(int x, int y, int m, int n, int k, boolean[][] flag) {
        if (x < 0 || y < 0 || x >= n || y >= m || flag[y][x] || bitSum(x, y) > k) {
            return 0;
        }

        int count = 1;
        flag[y][x] = true;
        // 上
        count += movingCount(x, y - 1, m, n, k, flag);
        // 下
        count += movingCount(x, y + 1, m, n, k, flag);
        // 左
        count += movingCount(x - 1, y, m, n, k, flag);
        // 右
        count += movingCount(x + 1, y, m, n, k, flag);
        return count;
    }

    private int bitSum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }

    public static void main(String... args) {
        MovingCount2 movingCount2 = new MovingCount2();
        System.out.println(movingCount2.movingCount(2, 3, 1));
        System.out.println(movingCount2.movingCount(3, 1, 0));
    }
}