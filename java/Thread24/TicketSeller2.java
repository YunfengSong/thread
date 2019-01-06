package Thread24;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:49
 * @Description://vector的所有方法都是加锁的
 */
public class TicketSeller2 {
    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号" + i);
        } }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size() > 0) {
                    System.out.println("销售"+tickets.remove(0));
                }
            }).start();
        }
    }
}
