package Thread20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/3 22:44
 * @Description:
 */
public class ReentrantLock4 {

    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        System.out.println("m1start");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void m2() {
        try {
            lock.lockInterruptibly();
            System.out.println("m2.start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ReentrantLock4 r1 = new ReentrantLock4();

        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(r1::m2);
        t2.start();
        t2.interrupt();




    }
}
