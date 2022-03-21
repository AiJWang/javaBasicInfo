package Study.ThreadInterrupt;

/**
 * @ClassName ThreadOne
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午8:14
 * @Version 1.0
 */
public class ThreadOne implements Runnable {
    public boolean flag = true;

    public synchronized void run() {
        try {
            while (flag) {
                wait();

                System.out.println(Thread.currentThread().getName() + "....running");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + "inter.....");
            flag = false;
        }
        System.out.println(Thread.currentThread().getName() + "....over");
    }
}
