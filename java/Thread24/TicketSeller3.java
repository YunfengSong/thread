package Thread24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:53
 * @Description:
 */
public class TicketSeller3 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票号" + i);
        } }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                while (true) {
                    synchronized (tickets) {
                        if (tickets.size()<=0)break;
                        System.out.println("销售" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
