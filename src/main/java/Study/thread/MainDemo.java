package Study.thread;

/**
 * @ClassName MainDemo
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/25 上午11:46
 * @Version 1.0
 */
public class MainDemo {
    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo("one");
        ThreadDemo demo1 = new ThreadDemo("two");
        demo.start();
        demo1.start();
        ThreadDemo demo2 = new ThreadDemo();
        demo2.start();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
