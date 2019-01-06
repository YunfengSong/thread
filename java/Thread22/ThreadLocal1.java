package Thread22;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:17
 * @Description:
 */
public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("p.name");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name ="lisli";
        }).start();
    }


}

class Person{
    String name = "zhansgan";
}