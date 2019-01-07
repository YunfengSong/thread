package Thread25;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 10:18
 * @Description:
 */
public class T06_ArrayBlockQueue {
    static BlockingQueue<String> strs=new ArrayBlockingQueue<String>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a"+i);
        }
        strs.add("aaa");//报出异
        strs.put("aaa");//满了等待
        strs.offer("aaa");//返回boolean
        strs.offer("aaa", 1,TimeUnit.SECONDS);
        System.out.println(strs);
    }
}
