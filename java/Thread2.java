/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 12:29
 * @Description: 可以用synchronized锁定this对象来完成同步
 */
public class Thread2 {

        private int count = 10 ;




        private void m() {
            synchronized(this){
                count -- ;
                System.out.println(Thread.currentThread().getName() + "  count =" + count);
            }
        }
    }

