package Thread25;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 10:25
 * @Description:
 */
public class T07_DelayQueue {
    static BlockingQueue<MyTask> task = new DelayQueue<>();

    static Random r = new Random();

    static class MyTask implements Delayed{
        long runningTime;
        MyTask(long runningTime){
            this.runningTime=runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime- System.currentTimeMillis(),TimeUnit.SECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.SECONDS)<o.getDelay(TimeUnit.SECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.SECONDS)>o.getDelay(TimeUnit.SECONDS))
                return 1;
            else return 0;
        }

        @Override
        public String toString() {
            return ""+runningTime;
        }
    }

    public static void main(String[] args)throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask(now+1000);
        MyTask t2 = new MyTask(now+2000);
        MyTask t3 = new MyTask(now+1500);
        MyTask t4 = new MyTask(now+2500);
        MyTask t5 = new MyTask(now+500);

        task.put(t1);
        task.put(t2);
        task.put(t3);
        task.put(t4);
        task.put(t5);
        System.out.println(task);
        for (int i = 0; i < 5; i++) {
            System.out.println(task.take());
        }
    }
}
