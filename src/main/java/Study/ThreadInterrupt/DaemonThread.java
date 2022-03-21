package Study.ThreadInterrupt;

/**
 * @ClassName DaemonThread
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/28 上午11:05
 * @Version 1.0
 */

//守护线程
public class DaemonThread {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();

        Thread thread = new Thread(threadOne);
        Thread thread1 = new Thread(threadOne);

        //设置为守护线程，当非守护线程被干掉之后，守护线程自动停止
        thread.setDaemon(true);
        thread1.setDaemon(true);

        thread.start();
        thread1.start();
        int num = 0;
        while (true) {
            if (num == 60) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "....." + num++);
        }
    }
}
