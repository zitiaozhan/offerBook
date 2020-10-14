/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item2;

import java.util.stream.IntStream;

/**
 * 单例模式1：懒汉模式-双检锁
 *
 * @author xingye
 * @created 2020/7/6
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    public static void main(String... args) {
        IntStream.rangeClosed(1, 10000).parallel().forEach(item -> {
            Singleton1 instance = Singleton1.getInstance();
            System.out.println(Thread.currentThread().getName() + " get this instance：" + instance);
        });
    }
}