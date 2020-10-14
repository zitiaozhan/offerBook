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
public class Singleton4 {
    private Singleton4(){}

    private static class InstanceHolder {
        private static Singleton4 instance;
    }

    public static Singleton4 getInstance(){
        return InstanceHolder.instance;
    }
}