/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 09:23
 * @Description: 不能锁定字符串，这样不好，会出问题
 */
public class Thread18 {
    String s1 = "hello" ;
    String s2 = "hello";

    void m1(){
        synchronized (s1) {

        }
    }
    void m2(){
        synchronized (s2) {

        }
    }
}
