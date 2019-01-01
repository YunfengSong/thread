import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 18:16
 * @Description:
 */
public class Thread11 {
    private  int count = 10 ;

    private synchronized void m() {
        System.out.println("m.start");

        while (true) {
            count--;
            System.out.println(Thread.currentThread().getName() + "Thread = " + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                try {
                    int i = 1/0;
                } catch (Exception e) {
                    System.out.println("caonima");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread11 t = new Thread11();

//        Runnable r = () ->t.m();
//        new Thread(r,"t1").start();

//        new Thread(t::m()).start();

//        new Thread(()->t.m()).start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(()->t.m()).start();



        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r ,"t2").start();

    }
}
