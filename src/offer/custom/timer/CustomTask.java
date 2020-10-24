/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.timer;

import java.lang.reflect.Method;

/**
 * 任务
 *
 * @author xingye
 * @created 2020/10/24
 */
public class CustomTask {
    /** 运行时间 */
    private long runTime;
    /** 方法引用 */
    private Method runMethod;

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public Method getRunMethod() {
        return runMethod;
    }

    public void setRunMethod(Method runMethod) {
        this.runMethod = runMethod;
    }
}