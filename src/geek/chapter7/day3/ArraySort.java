/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day3;

import java.util.Arrays;

/**
 * 实现归并排序、快速排序、插入排序、冒泡排序、选择排序
 *
 * @author xingye
 * @created 2020/11/24
 */
public class ArraySort {

    private void mergeSort(int[] nums) {
        if (null == nums) {
            return;
        }

        // 时间复杂度：Nlog(N)
        // 空间复杂度：N
        mergeSortCore(nums, 0, nums.length - 1);
    }

    private void mergeSortCore(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSortCore(nums, left, mid);
            mergeSortCore(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int l = left, r = mid + 1, index = 0;
        int[] tmp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            tmp[index++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            tmp[index++] = nums[l++];
        }
        while (r <= right) {
            tmp[index++] = nums[r++];
        }

        for (index = 0; index < tmp.length; index++) {
            nums[left + index] = tmp[index];
        }
    }

    private void quickSort(int[] nums) {
        if (null == nums) {
            return;
        }

        quickSortCore(nums, 0, nums.length - 1);
    }

    private void quickSortCore(int[] nums, int left, int right) {
        if (left < right) {
            // 随机交换
            int random = left + (int) (Math.random() * (right - left + 1));
            swap(nums, random, right);
            // 分区
            int[] parts = partition(nums, left, right);
            quickSortCore(nums, left, parts[0] - 1);
            quickSortCore(nums, parts[1] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int l = left - 1, r = right;
        while (left < r) {
            if (nums[left] > nums[right]) {
                swap(nums, left, --r);
            } else if (nums[left] < nums[right]) {
                swap(nums, left++, ++l);
            } else {
                left++;
            }
        }
        swap(nums, r, right);
        return new int[]{l + 1, r};
    }

    private void swap(int[] nums, int a, int b) {
        if (nums[a] == nums[b]) {
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    private void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i, tmp = nums[j + 1];
            while (j > -1 && tmp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    private void bubbleSort(int[] nums) {
        boolean swapFlag = true;
        for (int i = 0; i < nums.length && swapFlag; i++) {
            swapFlag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j + 1, j);
                    swapFlag = true;
                }
            }
        }
    }

    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
        }
    }

    private int findKthNum(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }

        int random = (int) (Math.random() * nums.length);
        swap(nums, random, nums.length - 1);
        int[] part = partition(nums, 0, nums.length - 1);

        k = k - 1;
        while (!(part[0] <= k && part[1] >= k)) {
            if (part[0] > k) {
                part = partition(nums, 0, part[0] - 1);
            } else {
                part = partition(nums, part[1] + 1, nums.length - 1);
            }
        }
        return nums[part[0]];
    }

    public static void main(String... args) {
        ArraySort arraySort = new ArraySort();
        int[] nums = new int[]{9, 2, 5, 1, 3, 0, 2, 3, -1, 6, 4, 5, 3};
//        arraySort.mergeSort(nums);
//        arraySort.quickSort(nums);
//        arraySort.insertSort(nums);
//        arraySort.bubbleSort(nums);
        System.out.println(arraySort.findKthNum(nums, 6));
        System.out.println(arraySort.findKthNum(nums, 9));
        System.out.println(arraySort.findKthNum(nums, 10));
        System.out.println(arraySort.findKthNum(nums, 1));
        System.out.println(arraySort.findKthNum(nums, 13));
        arraySort.selectSort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

}