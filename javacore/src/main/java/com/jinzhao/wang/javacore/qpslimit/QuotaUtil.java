package com.jinzhao.wang.javacore.qpslimit;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by WANGJINZHAO on 2018/1/31.
 */
public class QuotaUtil {

    //可以配置在zkz中随时调整，利用zk watcher机制随时动态的调整 配额
    //例如getUser:100    default:200
    volatile private static ConcurrentHashMap<String, Integer> apiQuota = new ConcurrentHashMap<String, Integer>() {{
        put("default", 5);
    }};


    private static final SlidingWindowCache<String, AtomicInteger> apiSplidWindow = new SlidingWindowCache(5 * 1000, 6);

    /**
     * 判断是否达到配置，达到配额则限流处理
     */
    public static boolean reachApiQuota(String apiName) {
        Integer quota = apiQuota.get(apiName) == null ? apiQuota.get("default") : apiQuota.get(apiName);
        try {
            AtomicInteger count = apiSplidWindow.get(apiName);
            if (null == count) {
                count = new AtomicInteger(0);
                apiSplidWindow.put(apiName, count);
            }
            if (count.incrementAndGet() > quota) {
                return true;
            }
        } catch (Exception e) {
            //TODO 记录log异常
        }
        return false;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    String content = System.currentTimeMillis() / 1000 + " " + QuotaUtil.reachApiQuota("test");
                    try {
                        FileUtils.writeLines(new File("d://quota"), "utf-8", Lists.newArrayList(content), true);
                        Thread.sleep(50L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
