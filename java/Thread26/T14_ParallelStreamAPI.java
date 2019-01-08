package Thread26;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/8 11:10
 * @Description:
 */
public class T14_ParallelStreamAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(100000+r.nextInt(1000000));

            System.out.println(list);

            long start =System.currentTimeMillis();
            list.forEach(v->isPrime(v));
            long end =System.currentTimeMillis();
            System.out.println(end - start);

            start=System.currentTimeMillis();
            list.parallelStream().forEach(T14_ParallelStreamAPI::isPrime);
            end = System.currentTimeMillis();
            System.out.println(end-start);
        }


    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if(num%i ==0) return  false;
        }
        return true;
    }
}
