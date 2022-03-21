package Study.ThreadJoinDemo;

/**
 * @ClassName JoinDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/28 上午11:14
 * @Version 1.0
 */
public class JoinDemo implements Runnable {

    public void run() {
        for (int i = 0; i < 90; i++) {
            System.out.println(Thread.currentThread().getName() + "......run " + i);
        }
    }
}
