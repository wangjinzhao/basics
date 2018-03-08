package com.jinzhao.wang.javacore.collection;

import com.jinzhao.wang.javacore.json.JacksonUtil;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by WANGJINZHAO on 2018/1/24.
 */
public class SetDemo {

    //差集
    public static void remove1() {
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();


        map1.put(1, "1");
        map1.put(2, "1");
        map1.put(3, "1");
        map1.put(4, "1");

        map2.put(5, "1");
        map2.put(6, "1");
        map2.put(3, "1");
        map2.put(4, "1");
        System.out.println(JacksonUtil.object2Json(map1));
        System.out.println(JacksonUtil.object2Json(map2));


        Set set1 = map1.keySet();
        Set set2 = map2.keySet();

//        Set set1 = new HashSet(map1.keySet());
//        Set set2 = new HashSet(map2.keySet());


        boolean removeFlag = set1.removeAll(set2);

        System.out.println(removeFlag);
        System.out.println(JacksonUtil.object2Json(set1));
        System.out.println(JacksonUtil.object2Json(set2));
        System.out.println(JacksonUtil.object2Json(map1));
        System.out.println(JacksonUtil.object2Json(map2));
    }


    public static void main(String[] args) {
        remove1();
    }

}
