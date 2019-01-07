package Thread25;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 18:02
 * @Description:
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
//        Map<String, String> map = new ConcurrentHashMap<>();//每个操作都加锁
//        Map<String, String> map = new ConcurrentSkipListMap<>();//高并发并且排序
        Map<String, String> map = new Hashtable<>();//每个操作都加锁
//        Map<String, String> map = new TreeMap<>();// 排好序
//        Map<String, String> map = new HashMap<>();//Collectio.synchronizedXXX

        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths .length);
        long star = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i]=new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("A"+r.nextInt(100000),"a"+r.nextInt(100000));
                }
            });

        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end =System.currentTimeMillis();
        System.out.println(end - star);
    }
}
