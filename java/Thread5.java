/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 12:47
 * @Description: 多线程使用synchronized输出案例
 */
public class Thread5 extends Thread  {
    private int count = 10;

    public /*synchronized*/ void run(){
        count--;
        System.out.println(Thread.currentThread().getName() + " " + count);
    }

    public static void main(String[] args) {
        Thread5 t1 = new Thread5();
        for (int i = 0; i < 5; i++) {
            new Thread(t1,"Thread"+i).start();
        }
    }

}
