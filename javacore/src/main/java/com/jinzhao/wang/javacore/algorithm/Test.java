package com.jinzhao.wang.javacore.algorithm;

import java.util.Arrays;

/**
 * Created by WANGJINZHAO on 2018/3/7.
 */
public class Test {


    public static void quickSort(int[] a, int left, int rigth) {
        if (left < rigth) {
            int i = left, j = rigth, povit = a[i];
            while (i < j) {
                while (i < j && a[j] >= povit) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < povit) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = povit;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, rigth);
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 9, 10, 7, 8, 6, 5, 4, 1};
        System.out.println();
        quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));

        int[] test1 = {2, 3, 9, 10, 7, 8, 6, 5, 4, 1};
        bubboSort(test1);
        System.out.println(Arrays.toString(test1));
    }

    public static void bubboSort(int [] a){
        for (int i=0;i<a.length-1;i++){
            boolean flag=true;
            for (int j=0;j<a.length-1-i;j++){
                if (a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=false;
                }
            }
            if (flag){
                break;
            }

        }
    }

}
