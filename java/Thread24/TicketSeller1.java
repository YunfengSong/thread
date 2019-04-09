package Thread24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:45
 * @Description: 卖票系统，这样一定会出问题。进行并行判断，这样很危险，
 */
public class TicketSeller1 {
    static List<String> tickets = new ArrayList<>();

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
