package Thread23;

import java.util.Arrays;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/6 17:38
 * @Description:
 */
public class Singleton {

    private Singleton() {
        System.out.println("singleton");
    }

    private static class  inner{
        private static  Singleton s =new Singleton();
    }

    private static Singleton getSingle() {
        return  inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i] =new Thread(()->{
               Singleton.getSingle();
            });
        }
        Arrays.asList(ths).forEach(o->o.start());
    }

}
