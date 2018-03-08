package com.jinzhao.wang.javacore.algorithm;

/**
 * Created by WANGJINZHAO on 2018/3/5.
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 */
public class BubboSort {
    public static void bubboSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubboSortImprvoe(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("外层循环进行的次数=" + i);
            int flag = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }

        }

    }

    public static void main(String[] args) {
        int[] test = {1, 9, 12, 0, 7, 8, 2, 6};
        bubboSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8};
        bubboSortImprvoe(test1);

    }

}
