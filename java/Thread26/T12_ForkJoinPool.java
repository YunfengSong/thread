package Thread26;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/8 10:56
 * @Description:
 */
public class T12_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] =r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction{
        int start ,end ;

        AddTask(int s, int end) {
            start=s;
            end=end;
        }

        @Override
        protected void compute() {
            if(end-start<=MAX_NUM){
                long sum = 0l;
                for (int i = start; i <end ; i++) {
                    sum += nums[i];
                }
                System.out.println("form"+start+"to"+end+"="+sum);
            }else {
                int middle =start +(end -start)/2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle,end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }
}
