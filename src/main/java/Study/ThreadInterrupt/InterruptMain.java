package Study.ThreadInterrupt;

/**
 * @ClassName InterruptMain
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/2/27 下午8:21
 * @Version 1.0
 */
//停止线程，interrupt，因为stop废弃了，强制让线程从冻结状态转为运行状态，然后操纵flag，结束线程
public class InterruptMain {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();

        Thread thread = new Thread(threadOne);
        Thread thread1 = new Thread(threadOne);

        thread.start();
        thread1.start();
        int num = 0;
        while (true) {
            if (num == 60) {
                thread.interrupt();
                thread1.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "....." + num++);
        }
    }
}
