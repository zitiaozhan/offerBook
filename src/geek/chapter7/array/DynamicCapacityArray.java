/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 实现一个支持动态扩容的数组
 *
 * @author xingye
 * @created 2020/11/16
 */
public class DynamicCapacityArray {
    private int size;
    private int[] nums;

    public DynamicCapacityArray() {
        size = 0;
        nums = new int[4];
    }

    public synchronized void add(int num) {
        if (size >= nums.length) {
            increaseCapacity();
        }

        nums[size++] = num;
    }

    private void increaseCapacity() {
        int oldLength = nums.length;
        int newLength = (oldLength << 1) + 1;
        if (newLength < 0) {
            throw new IllegalArgumentException("out of array length");
        }

        nums = Arrays.copyOf(nums, newLength);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return nums[index];
    }

    public int getNonRepeatCount(){
        return (int) Arrays.stream(nums).distinct().count();
    }

    public static void main(String... args) {
        DynamicCapacityArray capacityArray = new DynamicCapacityArray();
        IntStream.rangeClosed(0, 49999).parallel().forEach(capacityArray::add);
        System.out.println(capacityArray.getNonRepeatCount());
    }
}