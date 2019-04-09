/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 14:31
 * @Description: 继承thread类的类可以被启动线程，运行其run方法，用start启动
 */
public class Thread6 extends Thread{
    private  int count = 10;

    public synchronized void run() {
        count--;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + count);
    }

    public static void main(String[] agrs) {
        Thread6 t2 = new Thread6();
        for (int i = 0; i < 5; i++) {

            new Thread(t2,"Head "+ i).start();
        }
    }


}
