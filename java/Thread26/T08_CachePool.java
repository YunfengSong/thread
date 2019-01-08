package Thread26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/8 10:37
 * @Description:// 来一个启动一个 弹性线程 一分钟线程死掉
 */
public class T08_CachePool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        TimeUnit.SECONDS.sleep(80);
        System.out.println(service);
    }
}
