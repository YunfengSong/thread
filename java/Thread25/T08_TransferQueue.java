package Thread25;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 10:37
 * @Description:
 */
public class T08_TransferQueue {
    public static void main(String[] args)throws InterruptedException {
        LinkedTransferQueue<String> str = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                System.out.println(str.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        str.transfer("aaa");//找不到消费者会阻塞
    }
}
