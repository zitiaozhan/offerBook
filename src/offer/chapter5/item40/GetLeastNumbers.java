/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item40;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author xingye
 * @created 2020/9/19
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (null == arr || 0 == arr.length || k < 1 || k > arr.length) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }

        int l = 0, r = arr.length - 1, random = (int) (l + (Math.random() * (r - l + 1)));
        swap(arr, r, random);
        int[] edge = partition(arr, l, r);
        while (!(edge[0] <= k && edge[1] >= k)) {
            if (edge[0] > k) {
                r = edge[0] - 1;
            } else if (edge[1] < k) {
                l = edge[1] + 1;
            }

            random = (int) (l + (Math.random() * (r - l + 1)));
            swap(arr, r, random);
            edge = partition(arr, l, r);
        }

        return Arrays.copyOf(arr, k);
    }

    private int[] partition(int[] nums, int l, int r) {
        // 左右边界
        int left = l - 1, right = r;
        while (l < right) {
            if (nums[l] > nums[r]) {
                swap(nums, l, --right);
            } else if (nums[l] < nums[r]) {
                swap(nums, l++, ++left);
            } else {
                l++;
            }
        }
        swap(nums, r, right);

        return new int[]{left + 1, right};
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
        GetLeastNumbers leastNumbers = new GetLeastNumbers();
        System.out.println(Arrays.toString(leastNumbers.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10)));
    }

}