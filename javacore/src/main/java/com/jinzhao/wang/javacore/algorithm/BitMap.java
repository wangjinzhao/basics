package com.jinzhao.wang.javacore.algorithm;

import java.util.Random;

/**
 * Created by WANGJINZHAO on 2018/3/22.
 * https://www.jianshu.com/p/6082a2f7df8e
 * 10亿int数字=10亿*4byte=3.725G,现在1bit可以存储一个4byte的int有或是没有的状态0或1
 * 占用的内存3.725G/4*8bit=120M 。
 * byte[] 数组长度10亿/ 8=1.25亿   1.25亿byte/ 1024/1024=120兆
 * 前后反推对的上合理
 */
public class BitMap {

    private byte[] bits;
    private int capacity;

    public BitMap(int capacity) {
        this.capacity = capacity;//byte数组容量
        //1bit能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
        bits = new byte[(capacity >> 3) + 1];
    }


    public void add(int num) {
        //定位byte 数组的位置  上num/8  即可1byte=bit
        int index = num >> 3;
        // num%8得到在byte[index] 中8个bit位的位置
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        bits[index] |= 1 << position;
    }

    public boolean contains(int num) {
        int index = num >> 3;
        int position = num & 0x07;
        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[index] & (1 << position)) != 0;

    }

    public void clear(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);

    }


    public static void main(String[] args) {
//        System.out.println(14 >> 3);
//        System.out.println(14 % 8);
//        System.out.println(14 & 0x07);
//        System.out.println(0x07);
//        System.out.println(Integer.toBinaryString(7));

        BitMap bitMap = new BitMap(1000000);
        int repeatCount = 0;
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int testR = random.nextInt(1000000);
            if (bitMap.contains(testR)) {
                repeatCount++;
                System.out.println("已经包含===" + testR);
            }
            bitMap.add(testR);
        }
        System.out.println(repeatCount);

//        Random random = new Random(10);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(random.nextInt());
//        }
//
//        Random random1 = new Random(10);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(random1.nextInt());
//        }
    }

}
