package com.jinzhao.wang.javacore.thread;

/**
 * Created by WANGJINZHAO on 2018/3/18.
 */
public class Producer implements Runnable {
    ProductStack productStack;

    public Producer(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true) {
            productStack.produce(new ProductStack.Product("商品!" + System.currentTimeMillis()));
        }
    }
}
