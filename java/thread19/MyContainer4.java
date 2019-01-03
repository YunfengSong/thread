package thread19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 09:48
 * @Description: wait /notify 所动的对象可以使用wait/notify  notify不会释放锁
 */
public class MyContainer4 {

    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 c = new MyContainer3();

        final Object lock = new Object();

        new Thread(()->{

            synchronized (lock) {

                System.out.println("t2.start");

                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();


                System.out.println("t2.end");
            }




        },"t2").start();



        new Thread(()->{

            System.out.println("t1启动");

            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add" + i);

                    if (c.size() == 5) {
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



            System.out.println("t1结束");
        }).start();
    }
}

