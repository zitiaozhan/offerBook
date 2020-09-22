/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * 0~n-1中缺失的数字
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/21
 */
public class FindAbsentNumber2 {

    private int findAbsentNumber(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }

        int left = 0, right = nums.length - 1, mid = (left + right) >> 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] != mid) {
                if (mid > 0 && nums[mid - 1] != mid - 1) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        if (mid != nums[mid]) {
            return mid;
        }
        if (mid == right) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String... args) {
        FindAbsentNumber2 absentNumber2 = new FindAbsentNumber2();
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0, 1, 2}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0, 1, 3}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{1, 2, 3}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0, 1, 2, 5, 7}));
    }

}