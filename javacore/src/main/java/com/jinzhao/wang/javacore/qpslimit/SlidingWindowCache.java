package com.jinzhao.wang.javacore.qpslimit;


import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by WANGJINZHAO on 2018/1/31.
 * O(n) n为缓存桶数量 n越大时间复杂度越高
 * 缓存失效时间精度为 expirationMillis/(n-1)n越大精度越高
 */
public class SlidingWindowCache<K, V> {

    private LinkedList<ConcurrentHashMap<K, V>> buckets;
    private int bucketsNum;//缓存桶的数量
    private int expirationMillis;//缓存失效时间
    ScheduledExecutorService slidingWindowPool = Executors.newSingleThreadScheduledExecutor();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public SlidingWindowCache(final int expirationMillis, int bucketsNum) {
        this.init(expirationMillis, bucketsNum);
    }

    private void init(final int expirationMillis, int bucketsNum) {
        if (bucketsNum < 2) {
            throw new IllegalArgumentException("bucket num of SlidingWindow must be>=2,now bucketsNum=" + bucketsNum);
        }
        this.expirationMillis = expirationMillis;
        this.bucketsNum = bucketsNum;
        buckets = new LinkedList<ConcurrentHashMap<K, V>>();
        for (int i = 1; i <= bucketsNum; i++) {
            buckets.add(new ConcurrentHashMap<K, V>());
        }
        //利用LRU实现滑动窗口
        final long period = expirationMillis / (this.bucketsNum - 1);
        final SlidingWindowCache<K, V> window = this;
        slidingWindowPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                window.sliding();
            }
        }, 0, period, TimeUnit.MILLISECONDS);
    }


    private Map<K, V> sliding() {
        Map<K, V> dead = null;
        try {
            lock.writeLock().lock();
            buckets.addFirst(new ConcurrentHashMap<K, V>());
            dead = buckets.removeLast();
        } catch (Exception e) {
            throw e;
        } finally {
            lock.writeLock().unlock();
        }
        return dead;
    }

    public V get(K key) {
        V val = null;
        try {
            lock.readLock().lock();
            for (int j = 0; j < bucketsNum; j++) {
                if (buckets.get(j).containsKey(key) && null != buckets.get(j).get(key)) {
                    val = buckets.get(j).get(key);
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            lock.readLock().unlock();
        }
        return val;
    }

    public void put(K key, V value) {
        try {
            lock.readLock().lock();
            buckets.getFirst().put(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            lock.readLock().unlock();
        }
    }


}
