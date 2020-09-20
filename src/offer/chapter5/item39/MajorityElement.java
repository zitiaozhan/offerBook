/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item39;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author xingye
 * @created 2020/9/19
 */
public class MajorityElement {

    public Integer majorityElement(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        if (1 == nums.length) {
            return nums[0];
        }

        int[] edges = partition(nums, 0, nums.length - 1);
        int mid = nums.length / 2;
        while (!((edges[0] <= mid && edges[1] > mid) || (edges[0] < mid && edges[1] >= mid))) {
            int left = edges[0];
            int right = edges[1];

            if (left > mid) {
                edges = partition(nums, 0, left - 1);
            } else if (right < mid) {
                edges = partition(nums, right + 1, nums.length - 1);
            }
        }

        return nums[edges[0]];
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
        if (a == b || nums[a] == nums[b]) {
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String... args) {
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement(new int[]{5, 7, 5, 2, 5, 5, 5, 6}));
        System.out.println(element.majorityElement(new int[]{3, 2, 3}));
    }

}