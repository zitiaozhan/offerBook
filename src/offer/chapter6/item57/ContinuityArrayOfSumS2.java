/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item57;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * @author xingye
 * @created 2020/9/23
 */
public class ContinuityArrayOfSumS2 {

    private List<List<Integer>> getList(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }

        int half = sum / 2 + 1;
        int curSum = 3;
        int low = 1, high = 2;
        while (high <= half && low < high) {
            if (curSum == sum) {
                setRes(res, low, high);
                high++;
                curSum += high;
            } else if (curSum > sum) {
                curSum -= low;
                low++;
            } else {
                high++;
                curSum += high;
            }
        }

        return res;
    }

    private void setRes(List<List<Integer>> res, int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            list.add(i);
        }
        res.add(list);
    }

    public static void main(String... args) {
        ContinuityArrayOfSumS2 arrayOfSumS2 = new ContinuityArrayOfSumS2();
        System.out.println(arrayOfSumS2.getList(7));
        System.out.println(arrayOfSumS2.getList(3));
        System.out.println(arrayOfSumS2.getList(4));
        System.out.println(arrayOfSumS2.getList(5));
        System.out.println(arrayOfSumS2.getList(6));
        System.out.println(arrayOfSumS2.getList(8));
        System.out.println(arrayOfSumS2.getList(9));
        System.out.println(arrayOfSumS2.getList(10));
        System.out.println(arrayOfSumS2.getList(11));
        System.out.println(arrayOfSumS2.getList(12));
        System.out.println(arrayOfSumS2.getList(13));
        System.out.println(arrayOfSumS2.getList(14));
        System.out.println(arrayOfSumS2.getList(16));
        System.out.println(arrayOfSumS2.getList(100));
        System.out.println(arrayOfSumS2.getList(15));
    }

}