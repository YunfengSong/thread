package Thread26;

import java.util.concurrent.*;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 11:12
 * @Description:
 */
public class T05_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(5);
            return 1000;
        }) ;//new callable (){Integer call();}

        new Thread(task).start();

        System.out.println(task.get());

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f =service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });

        System.out.println(f.get());
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}
