/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item41;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/8
 */
public class MedianFinder6 {

    private CustomHeap maxHeap = new CustomHeap(false, 100);
    private CustomHeap minHeap = new CustomHeap(true, 100);
    private int size = 0;

    public void addNum(int num) {
        size++;

        if ((size & 1) == 1) {
            // 奇数放到大根堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (size == 0) {
            throw new IllegalArgumentException("无数据");
        }

        if ((size & 1) == 1) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    private static class CustomHeap {
        private boolean asc;
        private int maxSize;
        private int size;
        private int[] nums;

        public CustomHeap(boolean asc, int maxSize) {
            this.asc = asc;
            this.maxSize = maxSize;
            size = 0;
            nums = new int[maxSize];
        }

        /**
         * 向堆中添加数据
         */
        public void offer(int num) {
            if (size == maxSize) {
                throw new IllegalArgumentException("堆已满");
            }
            int index = size;
            nums[index] = num;
            size++;

            while (index > 0 && needSwap(num, nums[(index - 1) >> 1])) {
                swap(nums, index, (index - 1) >> 1);
                index = (index - 1) >> 1;
            }
        }

        /**
         * 移除堆根节点数据
         */
        public int poll() {
            if (size == 0) {
                throw new IllegalArgumentException("堆已空");
            }
            int result = nums[0];
            swap(nums, 0, --size);
            nums[size] = 0;
            // 重新调整堆
            heapify();

            return result;
        }

        public int peek() {
            return nums[0];
        }

        private void heapify() {
            int index = 0, left = 2 * index + 1;
            while (index < size && left < size) {
                int more = left + 1 < size && needSwap(nums[index + 1], nums[left]) ? left + 1 : left;
                more = needSwap(nums[more], nums[index]) ? more : index;

                if (more == index) {
                    break;
                }
                swap(nums, index, more);
                index = more;
                left = 2 * index + 1;
            }
        }

        private boolean needSwap(int a, int b) {
            return asc ? a < b : a > b;
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

    public static void main(String... args) {
        MedianFinder6 finder6 = new MedianFinder6();
        finder6.addNum(1);
        System.out.println(finder6.findMedian());
        finder6.addNum(2);
        System.out.println(finder6.findMedian());
        finder6.addNum(3);
        System.out.println(finder6.findMedian());
        finder6.addNum(4);
        System.out.println(finder6.findMedian());
        finder6.addNum(5);
        System.out.println(finder6.findMedian());
        finder6.addNum(6);
        System.out.println(finder6.findMedian());
        finder6.addNum(7);
        System.out.println(finder6.findMedian());
        finder6.addNum(8);
        System.out.println(finder6.findMedian());
        finder6.addNum(9);
        System.out.println(finder6.findMedian());
        finder6.addNum(10);
        System.out.println(finder6.findMedian());
    }

}