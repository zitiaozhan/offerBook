/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item11;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * P82
 *
 * @author xingye
 * @created 2020/7/14
 */
public class MinArray {

    /**
     * 1.使用二分查找算法进行查找
     * 2.旋转数组可划分为两个有序数组，且以最小值为分界线，且前面都大于后面元素
     * 3.使用二分，定位中间元素，若它位于前面递增数组，则它大于等于left，若它位于后面递减数组，则它小于等于right
     * 4.以此为基础，不断缩小查找范围
     *
     * @param numbers 旋转数组
     * @return 最小值
     */
    public int minArray(int[] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return -1;
        }
        int res = numbers[0];
        // 定义变量
        int left = 0, right = numbers.length - 1, mid = left + ((right - left) >> 1);
        if (numbers[left] < numbers[right]) {
            // 旋转部分长度为0时(如：1,2,3,4,5,6)，同时不能加相等判断，防止出现类似数组：2,2,2,1,2,2
            return numbers[0];
        }
        if (numbers[left] == numbers[mid] && numbers[right] == numbers[mid]) {
            // 提前处理二分不能处理的情况，类似数组：2,2,2,1,2,2
            for (int i = 1; i < numbers.length; i++) {
                res = Math.min(res, numbers[i]);
            }
            return res;
        }

        // 二分
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (right == left + 1) {
                // 由下面(numbers[mid] <= numbers[right])可知，最小值只会命中right位置
                return numbers[right];
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    /**
     * 一共三种情况：
     * 1.mid处小于r处，则 mid--r 递增，mid右边一定大于等于mid，最小值一定出现在左边，移动右边界
     * 2.mid处大于r处，则 mid--r一定递减或递减再递增，最小值一定出现在右边，移动左边界
     * 3.mid处等于r处，则r处可放弃
     *
     * @param numbers 数组
     * @return 最小值
     */
    public int minArray2(int[] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return -1;
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (numbers[mid] < numbers[r]) {
                // mid--r 递增，mid右边一定大于等于mid，抛弃一半
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                // mid--r一定递减或递减再递增，最小值一定出现在右边
                l = mid + 1;
            } else {
                // nums[r]==nums[mid]，去重
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String... args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray2(new int[]{3, 4, 5, 1, 2, 3}));
        System.out.println(minArray.minArray2(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(minArray.minArray2(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(minArray.minArray2(new int[]{4, 5, 6, 1, 2, 3}));
        System.out.println(minArray.minArray2(new int[]{5, 6, 1, 2, 3, 4}));
        System.out.println(minArray.minArray2(new int[]{}));
        System.out.println(minArray.minArray2(new int[]{2, 2, 2, 1, 2, 2}));
        System.out.println(minArray.minArray2(new int[]{2, 2, 2, 0, 1, 2}));
        System.out.println(minArray.minArray2(new int[]{3, 1}));
    }
}