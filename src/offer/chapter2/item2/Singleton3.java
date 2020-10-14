/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item2;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/9
 */
public class Singleton3 {
    private Singleton3(){}
    private static volatile Singleton3 instance;

    public static Singleton3 getInstance() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}