/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.timer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 自定义任务器
 *
 * @author xingye
 * @created 2020/10/24
 */
public class CustomTimer {
    /** 优先级队列 */
    private CustomQueue customQueue;

    public CustomTimer(int taskNum) {
        this.customQueue = new CustomQueue(taskNum);
    }

    public void execute() {
        while (true) {
            // 获取当前时间
            long currentTimeMillis = System.currentTimeMillis();
            // 与任务执行时间比较
            CustomTask peek = customQueue.peek();
            if (currentTimeMillis >= peek.getRunTime()) {
                CompletableFuture.runAsync(() -> {
                    try {
                        peek.getRunMethod().invoke(null, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                customQueue.poll();
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(peek.getRunTime() - currentTimeMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}