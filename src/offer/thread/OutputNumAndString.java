/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.thread;

/**
 * 在这里编写类的功能描述
 *
 * @author xinyeguo
 * @created 2020/10/10
 */
public class OutputNumAndString {
    private static volatile int flag = 1;
    private static Object lockObj = new Object();
    private static char[] nums = new char[]{'1', '2', '3', '4', '5'};
    private static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E'};

    public static void main(String... args) {
        m2();
    }

    private static void m1() {
        Thread thread1 = new Thread(() -> {
            for (char num : nums) {
                if (flag == 1) {
                    System.out.println(num);
                    flag = 2;
                }
                while (flag != 1) {
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c : chars) {
                while (flag != 2) {
                }
                if (flag == 2) {
                    System.out.println(c);
                    flag = 1;
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    private static void m2() {
        Thread thread1 = new Thread(() -> {
            for (char num : nums) {
                synchronized (lockObj) {
                    System.out.println(num);
                    lockObj.notify();
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c : chars) {
                synchronized (lockObj) {
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(c);
                    lockObj.notify();
                }
            }
        });
        thread2.start();
        thread1.start();
    }
}