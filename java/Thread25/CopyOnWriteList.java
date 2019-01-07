package Thread25;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 09:27
 * @Description: 写时复制，写的效率不高，读的效率高,wusuo
 */
public class CopyOnWriteList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();

        Random r = new Random();
        Thread[] ths = new Thread[100];

        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        list.add("a" + r.nextInt(10000));
                }
                };
                ths[i] =new Thread(task);

        };
        runAndComputetime(ths);


        System.out.println(list.size());

    }

    static void runAndComputetime(Thread[] ths) {
        long s1 =System.currentTimeMillis();
        Arrays.asList(ths).forEach(t -> t.start());
        Arrays.asList(ths).forEach(t ->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
