/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item2;

import java.util.stream.IntStream;

/**
 * 单利模式2：恶汉模式，内部类实现
 *
 * @author xingye
 * @created 2020/7/6
 */
public class Singleton2 {
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return InnerInstance.instance;
    }

    private static class InnerInstance {
        private static final Singleton2 instance = new Singleton2();
    }

    public static void main(String... args) {
        IntStream.rangeClosed(1, 10000).parallel().forEach(item -> {
            Singleton2 instance = Singleton2.getInstance();
            System.out.println(Thread.currentThread().getName() + " get this instance: " + instance);
        });
    }
}