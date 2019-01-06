package Thread21;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/3 23:19
 * @Description:
 */
public class MyContainer1 <T>{
    final private LinkedList<T> list = new LinkedList<T>();
    final private int MAX = 10;
    private int count =0;

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();
    }

    public synchronized T get() {
        T t =null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        return t;
    }

    public static void main(String[] args) {
        MyContainer1 c = new MyContainer1();

        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                for (int j = 0;  j< 10; j++) {
                    System.out.println(c.get());
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            }).start();
        }
    }


}
