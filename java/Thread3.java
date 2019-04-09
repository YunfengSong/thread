/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 12:31
 * @Description:可以用synchronized锁定方法名完成同步
 */
public class Thread3 {
    private  int  count = 9 ;


    private synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }
}
