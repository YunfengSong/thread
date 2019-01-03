package thread19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 10:09
 * @Description:
 */
public class MyContainer5 {



    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer5 c  = new MyContainer5();

        CountDownLatch lanch = new CountDownLatch(1);

        new Thread(() -> {


            System.out.println("t2.start");
            if (c.size() != 5) {
                try {
                    lanch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("t2.end");

        }).start();


        new Thread(() -> {
            System.out.println("ti.start");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add" + i);

                if (c.size() == 5) {
                    lanch.countDown();
                }
            }
        }).start();


    }
}
