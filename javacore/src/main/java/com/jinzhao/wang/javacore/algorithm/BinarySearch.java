package com.jinzhao.wang.javacore.algorithm;

/**
 * Created by WANGJINZHAO on 2018/3/7.
 */
public class BinarySearch {
    public static int binarySearch(int[] arry, int key) {
        int low = 0;
        int high = arry.length - 1;
        int count = 0;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arry[middle] == key) {
                System.out.println("查找次数=" + count);
                return middle;
            }
            if (arry[middle] > key)
                high = middle - 1;
            else
                low = middle + 1;
            count++;

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        int index = binarySearch(a, 8);
        System.out.println(index);
    }
}
