/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item2;

/**
 * 单例模式
 *
 * @author xingye
 * @created 2020/12/7
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {
    }

    public static synchronized Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                if (null == instance) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    public static Singleton5 getInstance2() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static Singleton5 instance = new Singleton5();
    }

}