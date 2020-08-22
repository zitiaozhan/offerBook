/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item39;

/**
 * P205
 * 数组中出现次数超过一半的数字
 *
 * @author xingye
 * @created 2020/8/21
 */
public class FindMostNumber {
    public static void main(String... args) {
        FindMostNumber mostNumber = new FindMostNumber();
        System.out.println(mostNumber.findMostNumber(new int[]{3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2}));
        System.out.println(mostNumber.findMostNumber2(new int[]{3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2}));
        System.out.println("#################");

        System.out.println(mostNumber.findMostNumber(new int[]{3, 6, 2, 6, 45, 346, 45, 2}));
        System.out.println(mostNumber.findMostNumber2(new int[]{3, 6, 2, 6, 45, 346, 45, 2}));
        System.out.println("#################");

        System.out.println(mostNumber.findMostNumber(new int[]{}));
        System.out.println(mostNumber.findMostNumber2(new int[]{}));
        System.out.println("#################");

        System.out.println(mostNumber.findMostNumber(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4}));
        System.out.println(mostNumber.findMostNumber2(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4}));
        System.out.println("#################");

        System.out.println(mostNumber.findMostNumber(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4, 4}));
        System.out.println(mostNumber.findMostNumber2(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4, 4}));
        System.out.println("#################");

        System.out.println(mostNumber.findMostNumber(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4, 6}));
        System.out.println(mostNumber.findMostNumber2(new int[]{4, 2, 4, 6, 1, 4, 9, 4, 4, 6}));

    }

    // 时间复杂度：O(NLogN), 可以理解为N次二分查找，空间复杂度：O(1)
    private int findMostNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        // 随机快排写法
        int[] boundary = partition(nums, 0, nums.length - 1);
        int left = boundary[0], right = boundary[1];
        int mid = nums.length >> 1;
        while (!(left <= mid && right >= mid)) {
            if (left > mid) {
                boundary = partition(nums, 0, left - 1);
            } else {
                boundary = partition(nums, right + 1, nums.length - 1);
            }
            left = boundary[0];
            right = boundary[1];
        }
        if (!checkMost(nums, nums[left])) {
            return -1;
        }

        return nums[left];
    }

    // 时间复杂度：O(N)，空间复杂度：O(1)
    private int findMostNumber2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        // 覆盖计数写法(摩尔投票)
        int result = -1, count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            } else if (count == 0) {
                result = num;
                count++;
            } else if (count > 0) {
                count--;
            }
        }
        if (!checkMost(nums, result)) {
            return -1;
        }
        return result;
    }

    private boolean checkMost(int[] nums, int res) {
        int times = 0;
        for (int num : nums) {
            if (num == res) {
                times++;
            }
        }
        return times > (nums.length >> 1);
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1, more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, left, --more);
            } else {
                left++;
            }
        }
        swap(nums, more, right);

        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b || nums[a] == nums[b]) {
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}