package com.jinzhao.wang.javacore.thread;

/**
 * Created by WANGJINZHAO on 2018/3/18.
 */
public class Consumer implements Runnable {
    ProductStack productStack;

    public Consumer(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true) {
            productStack.consumer();
        }
    }
}
