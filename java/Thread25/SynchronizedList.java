package Thread25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/7 09:47
 * @Description: 加锁小工厂
 */
public class SynchronizedList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);

    }
}
