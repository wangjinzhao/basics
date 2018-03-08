package com.jinzhao.wang.javacore.thread;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WANGJINZHAO on 2017/12/25.
 */
public class AQSDemo {


    static ReentrantLock lock = new ReentrantLock();
    static int status = 0;

    public static void addByLockControl() {
        lock.lock();
        status++;
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    addByLockControl();
                }
            };
            Thread thread=new Thread(runnable,"thread"+i);
            thread.start();
        }
        Thread.sleep(10000000L);
    }
}
