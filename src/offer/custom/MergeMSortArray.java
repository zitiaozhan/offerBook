/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom;

import java.util.Arrays;

/**
 * 合并M个长度为N的有序数组
 *
 * @author xingye
 * @created 2020/9/13
 */
public class MergeMSortArray {

    private int[] mergeMArray(int[][] nums) {
        if (null == nums || 0 == nums.length || 0 == nums[0].length) {
            return null;
        }

        int m = nums.length;
        return mergeMArrayCore(nums, 0, m - 1);
    }

    // 归并排序的方式,时间复杂度：MNlogM
    private int[] mergeMArrayCore(int[][] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + ((r - l) >> 1);
        int[] leftNums = mergeMArrayCore(nums, l, mid);
        int[] rightNums = mergeMArrayCore(nums, mid + 1, r);
        return mergeTwoArray(leftNums, rightNums);
    }

    /**
     * 合并两个有序数组
     */
    private int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index = 0, left = 0, right = 0;

        while (left < nums1.length && right < nums2.length) {
            result[index++] = nums1[left] < nums2[right] ? nums1[left++] : nums2[right++];
        }

        while (left < nums1.length) {
            result[index++] = nums1[left++];
        }
        while (right < nums2.length) {
            result[index++] = nums2[right++];
        }
        return result;
    }

    public static void main(String... args) {
        MergeMSortArray mergeMSortArray = new MergeMSortArray();
        System.out.println(Arrays.toString(mergeMSortArray.mergeMArray(new int[][]{{2, 4, 6}, {1, 3, 8}, {0, 5, 10}})));
        System.out.println(Arrays.toString(mergeMSortArray.mergeMArray(new int[][]{{2, 4, 6}, {1, 3, 8}, {0, 5, 10}, {0, 5, 6}})));
    }

}