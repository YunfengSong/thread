package Thread24;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:57
 * @Description:
 */
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号" + i);
        } }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true) {
                    String s =tickets.poll();
                    if(s==null)break;
                    System.out.println("销售"+tickets.remove(0));
                }
            }).start();
        }
    }
}
