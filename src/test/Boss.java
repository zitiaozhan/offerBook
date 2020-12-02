/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/1
 */
public class Boss {

    public static int[] retainAll(int[] array1, int[] array2) {
        if (null == array1 || null == array2) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                list.add(array1[index1]);
                index1++;
                index2++;
            } else if (array1[index1] < array2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) {
            res[index++] = num;
        }
        return res;
    }

    public static char find(char[] chars1, char[] chars2) {
        if (null == chars1 || null == chars2) {
            return Character.MIN_VALUE;
        }
        // 第一个数组比第二个数组多一个字符
        int left = 0, right = chars1.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid < chars2.length) {
                if (chars1[mid] == chars2[mid]) {
                    left = mid + 1;
                } else {
                    if (mid > 0) {
                        if (chars1[mid - 1] != chars2[mid - 1]) {
                            right = mid - 1;
                        } else {
                            return chars1[mid];
                        }
                    } else {
                        return chars1[0];
                    }
                }
            } else {
                return chars1[mid];
            }
        }
        return Character.MIN_VALUE;
    }

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    private void dieLock() {
        Thread a = new Thread(() -> {
            synchronized (lockA) {
                // do somethings
                sleepCurThread();
                System.out.println("获取lockB");
                synchronized (lockB) {
                    sleepCurThread();
                }
            }
        });
        Thread b = new Thread(() -> {
            synchronized (lockB) {
                // do somethings
                sleepCurThread();
                System.out.println("获取lockA");
                synchronized (lockA) {
                    sleepCurThread();
                }
            }
        });

        a.start();
        b.start(); // happen die lock
    }

    private void sleepCurThread() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // 错误日志
        }
    }

    public static void main(String... args) {
        Boss boss = new Boss();
        boss.dieLock();
    }

}