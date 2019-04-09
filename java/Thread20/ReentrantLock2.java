package Thread20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/3 22:29
 * @Description:  reentrantlock可以实现synchronized的所有功能
 */
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

     void m1() {
         lock.lock();

             for (int i = 0; i < 10; i++) {

                 System.out.println(i);

         }



             lock.unlock();

     }

    void m2() {
         lock.lock();
        System.out.println("m2");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r1 =new ReentrantLock1();

        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
