/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 09:23
 * @Description:
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
