package com.jinzhao.wang.javacore.thread;

import java.util.Stack;

/**
 * Created by WANGJINZHAO on 2018/3/18.
 */
public class ProductStack {

    final int capacity;//容量大小
    Stack<Product> stack = new Stack<>();

    public ProductStack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 生产
     */
    public synchronized void produce(Product product) {
        if (stack.size() == capacity) {
            try {
                System.out.println("仓库满了，不能添加商品，请等待！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产一个商品" + product.getId());
        stack.push(product);
        this.notifyAll();
    }

    /**
     * 消费
     */
    public synchronized void consumer() {
        if (stack.isEmpty()) {
            try {
                System.out.println("仓库空了,无商品可消费，等待！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product product = stack.pop();
        System.out.println("消费一个商品" + product.getId());
        this.notifyAll();
    }

    /**
     * 商品内部类
     */
    static class Product {
        String id;

        public Product(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        ProductStack productStack = new ProductStack(10);
        Thread consumer = new Thread(new Consumer(productStack));
        Thread producer = new Thread(new Producer(productStack));
        consumer.start();
        producer.start();
    }
}