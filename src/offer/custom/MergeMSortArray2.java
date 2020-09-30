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
 * @created 2020/9/30
 */
public class MergeMSortArray2 {
    // 归并合并
    private int[] mergeSortArray(int[][] nums) {
        if (null == nums || 0 == nums.length || 0 == nums[0].length) {
            return null;
        }

        return mergeCore(nums, 0, nums.length - 1);
    }

    private int[] mergeCore(int[][] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = start + ((end - start) >> 1);
        int[] leftArray = mergeCore(nums, start, mid);
        int[] rightArray = mergeCore(nums, mid + 1, end);

        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int leftLen = leftArray.length, rightLen = rightArray.length;
        int[] mergeArray = new int[leftLen + rightLen];
        int left = 0, right = 0, index = 0;

        while (left < leftLen && right < rightLen) {
            mergeArray[index++] = leftArray[left] <= rightArray[right] ? leftArray[left++] : rightArray[right++];
        }
        while (left < leftLen) {
            mergeArray[index++] = leftArray[left++];
        }
        while (right < rightLen) {
            mergeArray[index++] = rightArray[right++];
        }

        return mergeArray;
    }

    public static void main(String... args) {
        MergeMSortArray2 sortArray = new MergeMSortArray2();
        System.out.println(Arrays.toString(sortArray.mergeSortArray(new int[][]{{2, 4, 6}, {1, 3, 8}, {0, 5, 10}})));
        System.out.println(Arrays.toString(sortArray.mergeSortArray(new int[][]{{2, 4, 6}, {1, 3, 8}, {0, 5, 10}, {0, 5, 6}})));
    }
}