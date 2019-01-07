package Thread25;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 10:41
 * @Description:  //队列容量为0
 */
public class T09_SynchronizedQueue {
    public static void main(String[] args)throws InterruptedException {
        BlockingQueue<String> str = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(str.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        str.put("aaa");//被 阻塞，等待消费者---里面用的是transfer
        str.add("aaa");
        System.out.println(str.size());
    }
}
