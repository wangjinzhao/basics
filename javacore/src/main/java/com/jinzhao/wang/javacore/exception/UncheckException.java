package com.jinzhao.wang.javacore.exception;

/**
 * Created by WANGJINZHAO on 2017/12/14.
 */
public class UncheckException {

    public static void argumentException(){
        while (true){
            for(int i=0;i<10;i++){
                if (i==6){
                    throw new IllegalArgumentException("lack param");
                }
                System.out.println(i);
            }
            System.out.println("一直循环,直到退出");
        }
    }

    public static void main(String[] args) {
        argumentException();
    }
}
