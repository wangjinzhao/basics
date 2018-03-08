package com.jinzhao.wang.javacore.system;


/**
 * Created by WANGJINZHAO on 2017/10/12.
 */
public class SystemConfig {

    public static void main(String[] args) {
        //运行java的时候指定自定义参数，此处可以获取的到
        //编译该java文件，然后运行class文件指定自定义参数
        //javac  com.jinzhao.wang.javacore.system.SystemConfig.java  编译
        //java -Dport=8080 -Djetty_thread_pool_size=400  SystemConfig
        //当然jdk有很多内置的属性 比如：file.separator等
        String port=System.getProperty("port");
        String jettyPool=System.getProperty("jetty_thread_pool_size");
        System.out.println(port);
        System.out.print(jettyPool);
    }

}
