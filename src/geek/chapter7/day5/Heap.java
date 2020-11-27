/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day5;

import java.util.Arrays;

/**
 * 实现堆排序
 * 实现一个小顶堆、大顶堆、优先级队列
 *
 * @author xingye
 * @created 2020/11/27
 */
public class Heap {
    private int size;
    private int[] nums;
    private boolean asc;

    public Heap(boolean asc, int capacity) {
        this.asc = asc;
        nums = new int[capacity];
        size = 0;
    }

    public Heap() {
        this.asc = true;
        nums = new int[10];
        size = 0;
    }

    public void add(int cur) {
        if (size >= nums.length) {
            throw new RuntimeException();
        }
        int index = size++;
        nums[index] = cur;
        while (index > 0 && judgeSwap(nums[index], nums[(index - 1) >> 1])) {
            swap(nums, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    public int peek() {
        if (size <= 0) {
            throw new RuntimeException();
        }
        return nums[0];
    }

    public int poll() {
        if (size <= 0) {
            throw new RuntimeException();
        }

        int res = nums[0];
        swap(nums, 0, --size);
        heapify();

        return res;
    }

    private void heapify() {
        int index = 0, left = (index << 1) + 1;
        while (left < size) {
            int more = left + 1 < size && judgeSwap(nums[left + 1], nums[left]) ? left + 1 : left;
            if (!judgeSwap(nums[more], nums[index])) {
                break;
            }
            swap(nums, more, index);
            index = more;
            left = (index << 1) + 1;
        }
    }

    private boolean judgeSwap(int cur, int target) {
        return asc ? cur < target : cur > target;
    }

    private void heapSort(int[] nums) {
        if (null == nums) {
            return;
        }

        // 原始数组转化为大根堆
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }

        int size = nums.length;
        swap(nums, 0, --size);
        while (size > 1) {
            heapifyForSort(nums, size);
            swap(nums, 0, --size);
        }
    }

    private void heapifyForSort(int[] nums, int size) {
        int index = 0, left = (index << 1) + 1;
        while (left < size) {
            int maxIndex = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
            if (nums[index] >= nums[maxIndex]) {
                break;
            }
            swap(nums, maxIndex, index);
            index = maxIndex;
            left = (index << 1) + 1;
        }
    }

    private void heapInsert(int[] nums, int index) {
        while (index > 0 && nums[index] > nums[(index - 1) >> 1]) {
            swap(nums, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (nums[a] == nums[b]) {
            return;
        }

        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String... args) {
        /*Heap heap = new Heap();
        int[] nums = new int[]{9, 2, 5, 1, 3, 0, 2, 3, -1, 6, 4, 5, 3};
        heap.heapSort(nums);
        System.out.println(Arrays.toString(nums));*/

        Heap heap1 = new Heap(false, 20);
        heap1.add(2);
        heap1.add(5);
        heap1.add(3);
        heap1.add(7);
        heap1.add(3);
        heap1.add(2);
        heap1.add(4);
        heap1.add(0);
        System.out.println(Arrays.toString(heap1.nums));
        System.out.println(heap1.peek());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
    }

}