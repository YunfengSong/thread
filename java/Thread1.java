/**
 * @Auther: songyunfeng
 * @Date: 2019/1/1 10:46
 * @Description:    可以用synchronized锁定一个内部对象完成同步
 */
public class Thread1 {
    private int count = 10 ;
    private Object o = new Object();

//    @Override
//    public String toString() {
//        return "Thread1{" +
//                "count=" + count +
//                '}';
//    }

    private  void m() {
        synchronized(o){
            count -- ;
            System.out.println(Thread.currentThread().getName() + "  count =" + count);
        }
    }
}
