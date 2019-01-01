import java.util.concurrent.TimeUnit;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 17:32
 * @Description:脏读问题:业务代码对写加锁，读不加锁。
 */
public class Thread8 {
    private String name;
    private  double balance;

    private synchronized void set(String name, double balance) {
        this.name=name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    private double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Thread8 t = new Thread8();
        new Thread(()->t.set("张三",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getBalance());


    }
}
