package Thread25;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 09:50
 * @Description:
 */
public class ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("A" + i);
        }

        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.peek());
        System.out.println(strs.size());
        System.out.println(strs.poll());
        System.out.println(strs.size());
    }
}
