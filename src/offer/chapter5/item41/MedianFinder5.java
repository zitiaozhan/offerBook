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
 * @created 2020/9/27
 */
public class MedianFinder5 {
    private CustomHeap maxHeap = new CustomHeap(2500, false);
    private CustomHeap minHeap = new CustomHeap(2500, true);
    private int size = 0;

    public void addNum(int num) {
        size = size + 1;
        if ((size & 1) == 1) {
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
        private int size = 0;
        private int[] nums;
        private boolean asc;

        public CustomHeap(int size, boolean asc) {
            this.asc = asc;
            nums = new int[size];
        }

        public void offer(int num) {
            nums[size] = num;

            int index = size;
            while (index > 0 && needReplace(nums[index], nums[(index - 1) >> 1])) {
                swap(nums, index, (index - 1) >> 1);
                index = (index - 1) >> 1;
            }
            size = size + 1;
        }

        private int poll() {
            int cur = 0, res = nums[cur];
            swap(nums, cur, --size);
            nums[size] = 0;
            int left = (cur << 1) + 1;

            while (left <= size - 1) {
                int more = left + 1 <= size - 1 && needReplace(nums[left + 1], nums[left]) ? left + 1 : left;
                more = needReplace(nums[cur], nums[more]) ? cur : more;

                if (more == cur) {
                    break;
                }
                swap(nums, cur, more);
                cur = more;
                left = (cur << 1) + 1;
            }
            return res;
        }

        private int peek() {
            return nums[0];
        }

        public int size() {
            return size;
        }

        private boolean needReplace(int cur, int target) {
            if (asc) {
                return cur < target;
            }
            return cur > target;
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
        MedianFinder5 finder5 = new MedianFinder5();
        finder5.addNum(1);
        System.out.println(finder5.findMedian());
        finder5.addNum(2);
        System.out.println(finder5.findMedian());
        finder5.addNum(3);
        System.out.println(finder5.findMedian());
        finder5.addNum(4);
        System.out.println(finder5.findMedian());
        finder5.addNum(5);
        System.out.println(finder5.findMedian());
        finder5.addNum(6);
        System.out.println(finder5.findMedian());
        finder5.addNum(7);
        System.out.println(finder5.findMedian());
        finder5.addNum(8);
        System.out.println(finder5.findMedian());
        finder5.addNum(9);
        System.out.println(finder5.findMedian());
        finder5.addNum(10);
        System.out.println(finder5.findMedian());
    }

}