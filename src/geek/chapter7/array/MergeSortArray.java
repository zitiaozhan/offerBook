/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.array;

import java.util.Arrays;

/**
 * 实现两个有序数组合并为一个有序数组
 *
 * @author xingye
 * @created 2020/11/17
 */
public class MergeSortArray {

    public int[] mergeSortArray(int[] nums1, int[] nums2) {
        int left = 0, right = 0, index = 0;
        int[] res = new int[nums1.length + nums2.length];

        while (left < nums1.length && right < nums2.length) {
            res[index++] = nums1[left] <= nums2[right] ? nums1[left++] : nums2[right++];
        }

        while (left < nums1.length) {
            res[index++] = nums1[left++];
        }
        while (right < nums2.length) {
            res[index++] = nums2[right++];
        }
        return res;
    }

    public static void main(String... args) {
        MergeSortArray mergeSortArray = new MergeSortArray();
        System.out.println(Arrays.toString(mergeSortArray.mergeSortArray(new int[]{1, 3, 5, 7, 9, 9}, new int[]{2, 4, 6, 7, 7, 9})));
    }

}