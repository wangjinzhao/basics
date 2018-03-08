package com.jinzhao.wang.javacore.system;

/**
 * Created by WANGJINZHAO on 2017/11/9.
 */
public class StringUtil {


    public static void testSplit(){
        String splitStr="/test/wang/jin";
        String[] splitArr=splitStr.split("/");
        for (String index:splitArr) {
            System.out.println(index);
        }
        System.out.println(splitArr.length);
    }


    public static void main(String[] args) {
        testSplit2();
    }

    public static void testSplit2(){
        String splitStr="-";
        String[] splitArr=splitStr.split("-");
//        for (String index:splitArr) {
//            System.out.println(index);
//        }
        System.out.println(splitArr.length);

        String splitStr1="A-";
        String[] splitArr1=splitStr1.split("-");
        System.out.println(splitArr1.length);


        String splitStr2="-a";
        String[] splitArr2=splitStr2.split("-");
        System.out.println(splitArr2.length);

        System.out.println(splitArr2[0]+"=======");

        String splitStr3="a-a";
        String[] splitArr3=splitStr3.split("-");
        System.out.println(splitArr3.length);

    }

}
