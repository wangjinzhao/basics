package com.jinzhao.wang.javacore.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by WANGJINZHAO on 2017/10/17.
 */
public class NamedThreadFactory implements ThreadFactory {
    private static final AtomicInteger INSTANCE_NUM = new AtomicInteger();
    private final AtomicInteger THREAD_NUM = new AtomicInteger();
    private final String namePrefix;

    public NamedThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix+"-"+INSTANCE_NUM;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread newThread;
        String name = namePrefix + "-" + THREAD_NUM.incrementAndGet();
        newThread = new Thread(r, name);
        return newThread;
    }
}
