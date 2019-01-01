import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 17:55
 * @Description:锁的都是子类对象
 */
public class Thread10 {
    protected synchronized void m() {
        System.out.println("mstart");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

     class TT extends Thread10{
         @Override
         protected synchronized void m() {
             System.out.println("chiled");
             super.m();
             System.out.println("child end");
         }
     }
