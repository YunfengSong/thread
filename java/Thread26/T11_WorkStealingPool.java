package Thread26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/8 10:48
 * @Description:
 */
public class T11_WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        //产生精灵线程，主线程不阻塞看不到输出
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class R implements Runnable {
        int time;

        R(int time) {
            this.time=time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time + " "+ Thread.currentThread().getName());
        }
    }

}
