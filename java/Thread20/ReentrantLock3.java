package Thread20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/3 22:34
 * @Description: 可以实现尝试锁定
 */
public class ReentrantLock3 {

    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();

        for (int i = 0; i < 10; i++) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);

        }


        lock.unlock();

    }

    void m2() {

        boolean locked = lock.tryLock();
        System.out.println("m1"+locked);

       /* try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2"+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(locked) lock.unlock();
        }*/
    }

    public static void main(String[] args) {
        ReentrantLock3 r1 =new ReentrantLock3();

        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
