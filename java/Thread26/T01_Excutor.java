package Thread26;

import java.util.concurrent.Executor;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 10:49
 * @Description:
 */
public class T01_Excutor implements Executor {
    public static void main(String[] args) {
        new T01_Excutor().execute(()-> System.out.println("hello ex"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
       //new Thread(command).run();
    }
}
