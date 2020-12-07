/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

import java.util.concurrent.CountDownLatch;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/4
 */
public class Test {

    private void test(){
        CountDownLatch latch=new CountDownLatch(2);

        Thread t1 = new Thread(()->{
                // 操作1
                latch.countDown();
        });
        Thread t2 = new Thread(()->{
                // 操作1
                latch.countDown();
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}