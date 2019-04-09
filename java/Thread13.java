import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 23:25
 * @Description: Atomic类其加减具有原子性
 */
public class Thread13 {
    //    private /*volatile*/ int count = 0;
    AtomicInteger count = new AtomicInteger();


    private /*synchronized*/ void  m() {
        for (int i = 0; i < 10000; i++) {
//            count++;
            count.incrementAndGet();//count++不具备原子性。但atomatic类操作具备原子性 内部可能是cas
        }
    }

    public static void main(String[] args) {
        Thread13 t = new Thread13();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread"+i));
        }

        threads.forEach((o)->o.start());

      /*  threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        */
        System.out.println(t.count);
    }
}
