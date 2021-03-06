/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 12:35
 * @Description:锁定静态方法相当于直接锁定类对象
 */
public class Thread4 {
     private static int count = 10;

     private synchronized static void m(){
         count--;
         System.out.println(Thread.currentThread().getName() + " " + count);
     }

//     写法等同于上
    private static void mm() {
        synchronized (Thread4.class){
            count--;
        }
    }
}
