import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 23:16
 * @Description:volatile
 */
public class Thread12 {
    /*volatile */ boolean running = true;

    private void m() {
        System.out.println("m.start");
        while (running) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m.end");
    }

    public static void main(String[] args) {
        Thread12 t = new Thread12();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running=false;
    }
}