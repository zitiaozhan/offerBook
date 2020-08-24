/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item40;

/**
 * P209
 * 最小的K个数
 *
 * @author xingye
 * @created 2020/8/22
 */
public class MinKNumber {
    public static void main(String... args) {
        MinKNumber kNumber = new MinKNumber();
        kNumber.minKNumber(new int[]{7, 1, 3, 6, 3, 0}, 3);
    }

    private int[] minKNumber(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k > nums.length) {
            k = nums.length;
        }

        int[] res = new int[k];
        // 初始化大小为k数组
        System.arraycopy(nums, 0, res, 0, k);
        // 调整为大根堆
        for (int i = 0; i < res.length; i++) {
            heapInsert(res, i);
        }

        // 插入目标数组的其他数字
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < res[0]) {
                // 比根节点数值小，则替换根节点，并调整堆
                res[0] = nums[i];
                // 时间复杂度：log(K)
                heapify(res, 0, k);
            }
        }

        swap(res, 0, --k);
        while (k > 0) {
            heapify(res, 0, k);
            swap(res, 0, --k);
        }

        return res;
    }

    private void heapInsert(int[] nums, int pos) {
        // 大于父节点则交换
        while (nums[pos] > nums[(pos - 1) / 2]) {
            swap(nums, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

    private void heapify(int[] nums, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int largest = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[i] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (nums == null || nums.length < 2 || a == b || nums[a] == nums[b]) {
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

}