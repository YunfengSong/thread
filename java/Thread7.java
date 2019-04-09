/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 14:39
 * @Description: 不用synchronized的方法不被同步，不需要获得对象就可以使用
 */
public class Thread7 {

    private synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1.start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1.end");
    }

    private /*synchronized*/ void m2() {
        System.out.println(Thread.currentThread().getName() + "m2.start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2.end");
    }

    public static void main(String[] args) {
        Thread7 t = new Thread7();

//        new Thread(()->t.m1(),"m1").start();
//        new Thread(()->t.m2(),"m1").start();

        /*new Thread(t::m1(),"m1").start();
        new Thread(t::m2(),"m1").start();*/

      new Thread(new Runnable() {
          @Override
          public void run() {
              t.m1();
          }
      },"head").start();


    }
}
