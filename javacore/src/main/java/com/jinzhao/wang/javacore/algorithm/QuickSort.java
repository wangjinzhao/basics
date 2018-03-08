package com.jinzhao.wang.javacore.algorithm;

import java.util.Arrays;

/**
 * Created by WANGJINZHAO on 2018/3/6.
 */
public class QuickSort {

    private static void quickSort(int array[], int left, int right) {
        int i, j, povit;
        if (left < right) {
            i = left;
            j = right;
            povit = array[i];
            while (i < j) {
                while (array[j] >= povit && i < j) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }
                while (i < j && array[i] <= povit) {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = povit;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);

        }


    }


    public static void main(String[] args) {
        int[] test = {2, 3, 9, 10, 7, 8, 6, 5, 4, 1};
        System.out.println();
        quickSort(test, 0, test.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}


