/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day1.array;

import java.util.Arrays;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 *
 * @author xingye
 * @created 2020/11/16
 */
public class SortArray {
    private int capacity;
    private int size;
    private int[] sortArray;

    public SortArray(int capacity) {
        this.capacity = capacity;
        this.sortArray = new int[this.capacity];
    }

    public void add(int num) {
        if (size >= capacity) {
            throw new RuntimeException("out of array length");
        }
        int index = size - 1;
        while (index > -1) {
            if (sortArray[index] <= num) {
                break;
            }
            sortArray[index + 1] = sortArray[index];
            index--;
        }
        sortArray[index + 1] = num;
        size++;
    }

    public void add2(int num) {
        if (size >= capacity) {
            throw new RuntimeException("out of array length");
        }
        // 二分查找，找到第一个大于num的下标
        int start = 0, end = size - 1, mid, index = -1;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (sortArray[mid] > num) {
                if (mid > 0 && sortArray[mid - 1] <= num) {
                    index = mid;
                    break;
                }
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (index > -1) {
            System.arraycopy(sortArray, index, sortArray, index + 1, size - index);
            sortArray[index] = num;
        } else {
            sortArray[size] = num;
        }
        size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int deleted = sortArray[index];
        for (; index < size - 1; index++) {
            sortArray[index] = sortArray[index + 1];
        }
        size--;
        return deleted;
    }

    public void set(int index, int newVal) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int oldVal = sortArray[index];
        if (oldVal == newVal) {
            return;
        }

        if (newVal > oldVal) {
            while (index < size - 1) {
                if (sortArray[index + 1] >= newVal) {
                    break;
                }
                sortArray[index] = sortArray[++index];
            }
        } else {
            while (index > 0) {
                if (sortArray[index - 1] <= newVal) {
                    break;
                }
                sortArray[index] = sortArray[--index];
            }
        }
        sortArray[index] = newVal;
    }

    public void print() {
        System.out.println(Arrays.toString(sortArray));
    }

    public static void main(String... args) {
        SortArray sortArray = new SortArray(18);
        for (int i = 0; i < 6; i++) {
            sortArray.add(i * 3 + 1);
        }
        sortArray.print();
        for (int i = 0; i < 6; i++) {
            sortArray.add2(i * 2 + 1);
        }
        sortArray.print();
        sortArray.set(1, 10);
        sortArray.print();
        System.out.println(sortArray.delete(5));
        sortArray.print();
    }

}