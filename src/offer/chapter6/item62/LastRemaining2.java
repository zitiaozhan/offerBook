/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item62;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/30
 */
public class LastRemaining2 {

    // 题解：https://blog.csdn.net/u011500062/article/details/72855826
    // f(N,M)=(f(N−1,M)+M)%n，动态规划递推公式，从下到上求解
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            // 每一次删除数字，后面的下标都集体向前移动m
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String... args) {
        LastRemaining2 remaining2 = new LastRemaining2();
        System.out.println(remaining2.lastRemaining(5, 3));
    }

}