import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 23:52
 * @Description: synchronized优化，细化其锁粒度，可以优化整体性能
 */
public class Thread16 {
    private int count  = 0;

    private synchronized void m1() {
        count++;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private  void m2() {
        synchronized (this){
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
