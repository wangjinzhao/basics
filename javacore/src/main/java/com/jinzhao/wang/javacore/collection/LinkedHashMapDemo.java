package com.jinzhao.wang.javacore.collection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by WANGJINZHAO on 2018/1/12.
 */
public class LinkedHashMapDemo {

    public static LinkedHashMap<String,Integer>  linkedHashMapAccess=new LinkedHashMap(32,0.75f,true);
    public static LinkedHashMap<String,Integer> linkedHashMap=new LinkedHashMap(32);
    public static ArrayList list=new ArrayList();
    public static void main(String[] args) {

        linkedHashMap.put(null,1);


        for (int i = 0; i <50 ; i++) {
            String key=UUID.randomUUID().toString();
            System.out.println(key);
            linkedHashMapAccess.put(key,i);
            linkedHashMap.put(key,i);
            list.add(key);
        }

        for (Map.Entry<String,Integer> entry:linkedHashMapAccess.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        // accessOrder=true 按照访问顺序。get put会改变双向链表的顺序，前后两次迭代顺序不一致，被操作的这个key会放到队列尾部
        System.out.println(linkedHashMapAccess.get(list.get(30)));
        for (Map.Entry<String,Integer> entry:linkedHashMapAccess.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        // accessOrder=false 按照插入顺序，两次迭代之间有元素被访问，但是迭代结果输出一样。
        for (Map.Entry<String,Integer> entry:linkedHashMap.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        // accessOrder=true 按照访问顺序。get put会改变双向链表的顺序，前后两次迭代顺序不一致，被操作的这个key会放到队列尾部
        System.out.println(linkedHashMap.get(list.get(30)));
        for (Map.Entry<String,Integer> entry:linkedHashMap.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }



}
